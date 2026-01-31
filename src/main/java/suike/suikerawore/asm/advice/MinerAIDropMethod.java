package suike.suikerawore.asm.advice;

import java.util.Map;

import suike.suikerawore.inter.IMethod;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.AdviceAdapter;

import com.google.common.collect.ImmutableMap;

public class MinerAIDropMethod extends MethodVisitor implements IMethod {
    private String type = "0"; // 无类型

    public MinerAIDropMethod(AdviceAdapterData data) {
        super(Opcodes.ASM5, data.mv);
    }

// 需要修改的方法
    @Override
    public Map<String, String[]> getMethods() {
        return ImmutableMap.<String, String[]>builder()
            .put("mine", new String[] {"(Lnet/minecraft/util/math/BlockPos;Z)V", "mine"})
            .build();
    }

    @Override
    public MethodVisitor setMethodType(String type) {
        this.type = type;
        return this;
    }

// 修改部分
    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (this.type.equals("mine") && "getDrops".equals(name) && "(Lnet/minecraft/util/NonNullList;Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)V".equals(desc)) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
            this.modifyDrop();
        } else {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }
    }

    private void modifyDrop() {
        mv.visitVarInsn(Opcodes.ALOAD, 5);
        mv.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "suike/suikerawore/event/dropevent/BreakingEvent",
            "getDrops",
            "(Lnet/minecraft/util/NonNullList;)Lnet/minecraft/util/NonNullList;",
            false
        );
        mv.visitVarInsn(Opcodes.ASTORE, 5); 
    }
}