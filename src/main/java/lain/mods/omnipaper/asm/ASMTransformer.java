package lain.mods.omnipaper.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ASMTransformer implements IClassTransformer
{

    class transformer001 extends ClassVisitor
    {

        class method001 extends MethodVisitor
        {

            public method001(MethodVisitor mv)
            {
                super(Opcodes.ASM5, mv);
            }

            @Override
            public void visitInsn(int opcode)
            {
                if (opcode == Opcodes.IRETURN)
                {
                    this.visitVarInsn(Opcodes.ISTORE, 2);
                    this.visitVarInsn(Opcodes.ALOAD, 0);
                    this.visitVarInsn(Opcodes.ALOAD, 1);
                    this.visitVarInsn(Opcodes.ILOAD, 2);
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "showDurabilityBar", "(Lnet/minecraft/item/Item;Lnet/minecraft/item/ItemStack;Z)Z", false);
                }
                super.visitInsn(opcode);
            }

        }

        class method002 extends MethodVisitor
        {

            public method002(MethodVisitor mv)
            {
                super(Opcodes.ASM5, mv);
            }

            @Override
            public void visitInsn(int opcode)
            {
                if (opcode == Opcodes.IRETURN)
                {
                    this.visitVarInsn(Opcodes.ISTORE, 2);
                    this.visitVarInsn(Opcodes.ALOAD, 0);
                    this.visitVarInsn(Opcodes.ALOAD, 1);
                    this.visitVarInsn(Opcodes.ILOAD, 2);
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "getMetadata", "(Lnet/minecraft/item/Item;Lnet/minecraft/item/ItemStack;I)I", false);
                }
                super.visitInsn(opcode);
            }

        }

        class method003 extends MethodVisitor
        {

            public method003(MethodVisitor mv)
            {
                super(Opcodes.ASM5, mv);
            }

            @Override
            public void visitInsn(int opcode)
            {
                if (opcode == Opcodes.DRETURN)
                {
                    this.visitVarInsn(Opcodes.DSTORE, 2);
                    this.visitVarInsn(Opcodes.ALOAD, 0);
                    this.visitVarInsn(Opcodes.ALOAD, 1);
                    this.visitVarInsn(Opcodes.DLOAD, 2);
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "getDurabilityForDisplay", "(Lnet/minecraft/item/Item;Lnet/minecraft/item/ItemStack;D)D", false);
                }
                super.visitInsn(opcode);
            }

        }

        class method004 extends MethodVisitor
        {

            public method004(MethodVisitor mv)
            {
                super(Opcodes.ASM5, mv);
            }

            @Override
            public void visitInsn(int opcode)
            {
                if (opcode == Opcodes.ARETURN)
                {
                    this.visitVarInsn(Opcodes.ASTORE, 2);
                    this.visitVarInsn(Opcodes.ALOAD, 0);
                    this.visitVarInsn(Opcodes.ALOAD, 1);
                    this.visitVarInsn(Opcodes.ALOAD, 2);
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "getUnlocalizedName", "(Lnet/minecraft/item/Item;Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Ljava/lang/String;", false);
                }
                super.visitInsn(opcode);
            }

        }

        String mN001 = "showDurabilityBar"; // showDurabilityBar
        String mD001 = "(Lamj;)Z"; // (Lnet/minecraft/item/ItemStack;)Z
        String mN002 = "getMetadata"; // getMetadata
        String mD002 = "(Lamj;)I"; // (Lnet/minecraft/item/ItemStack;)I
        String mN003 = "getDurabilityForDisplay"; // getDurabilityForDisplay
        String mD003 = "(Lamj;)D"; // (Lnet/minecraft/item/ItemStack;)D
        String mN004 = "e_"; // getUnlocalizedName
        String mD004 = "(Lamj;)Ljava/lang/String;"; // (Lnet/minecraft/item/ItemStack;)Ljava/lang/String;

        public transformer001(ClassVisitor cv)
        {
            super(Opcodes.ASM5, cv);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
        {
            if (mN001.equals(name) && mD001.equals(desc))
                return new method001(super.visitMethod(access, name, desc, signature, exceptions));
            if (mN002.equals(name) && mD002.equals(desc))
                return new method002(super.visitMethod(access, name, desc, signature, exceptions));
            if (mN003.equals(name) && mD003.equals(desc))
                return new method003(super.visitMethod(access, name, desc, signature, exceptions));
            if (mN004.equals(name) && mD004.equals(desc))
                return new method004(super.visitMethod(access, name, desc, signature, exceptions));
            return super.visitMethod(access, name, desc, signature, exceptions);
        }

    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if ("net.minecraft.item.Item".equals(transformedName))
            return transform001(bytes);
        return bytes;
    }

    private byte[] transform001(byte[] bytes)
    {
        ClassReader classReader = new ClassReader(bytes);
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classReader.accept(new transformer001(classWriter), ClassReader.EXPAND_FRAMES);
        return classWriter.toByteArray();
    }

}
