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
                if (opcode == Opcodes.DRETURN)
                {
                    this.visitVarInsn(Opcodes.DSTORE, 2);
                    this.visitVarInsn(Opcodes.ALOAD, 0);
                    this.visitVarInsn(Opcodes.ALOAD, 1);
                    this.visitVarInsn(Opcodes.DLOAD, 2);
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "getDurabilityForDisplay", "(Lnet/minecraft/item/ItemEditableBook;Lnet/minecraft/item/ItemStack;D)D", false);
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
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "getItemStackLimit", "(Lnet/minecraft/item/ItemEditableBook;Lnet/minecraft/item/ItemStack;I)I", false);
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
                if (opcode == Opcodes.IRETURN)
                {
                    this.visitVarInsn(Opcodes.ISTORE, 2);
                    this.visitVarInsn(Opcodes.ALOAD, 0);
                    this.visitVarInsn(Opcodes.ALOAD, 1);
                    this.visitVarInsn(Opcodes.ILOAD, 2);
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "getMetadata", "(Lnet/minecraft/item/ItemEditableBook;Lnet/minecraft/item/ItemStack;I)I", false);
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
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "getUnlocalizedName", "(Lnet/minecraft/item/ItemEditableBook;Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Ljava/lang/String;", false);
                }
                super.visitInsn(opcode);
            }

        }

        class method005 extends MethodVisitor
        {

            public method005(MethodVisitor mv)
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
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "showDurabilityBar", "(Lnet/minecraft/item/ItemEditableBook;Lnet/minecraft/item/ItemStack;Z)Z", false);
                }
                super.visitInsn(opcode);
            }

        }

        class method006 extends MethodVisitor
        {

            public method006(MethodVisitor mv)
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
                    this.visitMethodInsn(Opcodes.INVOKESTATIC, "lain/mods/omnipaper/asm/Hooks", "hasEffect", "(Lnet/minecraft/item/ItemEditableBook;Lnet/minecraft/item/ItemStack;Z)Z", false);
                }
                super.visitInsn(opcode);
            }

        }

        String mN001 = ObfHelper.newName("getDurabilityForDisplay", "getDurabilityForDisplay");
        String mD001 = ObfHelper.newName("(Lamj;)D", "(Lnet/minecraft/item/ItemStack;)D");
        boolean foundM001 = false;
        String mO001 = ObfHelper.newName("alq", "net/minecraft/item/Item");

        String mN002 = ObfHelper.newName("getItemStackLimit", "getItemStackLimit");
        String mD002 = ObfHelper.newName("(Lamj;)I", "(Lnet/minecraft/item/ItemStack;)I");
        boolean foundM002 = false;
        String mO002 = ObfHelper.newName("alq", "net/minecraft/item/Item");

        String mN003 = ObfHelper.newName("getMetadata", "getMetadata");
        String mD003 = ObfHelper.newName("(Lamj;)I", "(Lnet/minecraft/item/ItemStack;)I");
        boolean foundM003 = false;
        String mO003 = ObfHelper.newName("alq", "net/minecraft/item/Item");

        String mN004 = ObfHelper.newName("e_", "getUnlocalizedName");
        String mD004 = ObfHelper.newName("(Lamj;)Ljava/lang/String;", "(Lnet/minecraft/item/ItemStack;)Ljava/lang/String;");
        boolean foundM004 = false;
        String mO004 = ObfHelper.newName("alq", "net/minecraft/item/Item");

        String mN005 = ObfHelper.newName("f", "hasEffect");
        String mD005 = ObfHelper.newName("(Lamj;)Z", "(Lnet/minecraft/item/ItemStack;)Z");
        boolean foundM005 = false;
        String mO005 = ObfHelper.newName("alq", "net/minecraft/item/Item");

        String mN006 = ObfHelper.newName("showDurabilityBar", "showDurabilityBar");
        String mD006 = ObfHelper.newName("(Lamj;)Z", "(Lnet/minecraft/item/ItemStack;)Z");
        boolean foundM006 = false;
        String mO006 = ObfHelper.newName("alq", "net/minecraft/item/Item");

        public transformer001(ClassVisitor cv)
        {
            super(Opcodes.ASM5, cv);
        }

        @Override
        public void visitEnd()
        {
            if (!foundM001)
            {
                MethodVisitor mv = this.visitMethod(Opcodes.ACC_PUBLIC, mN001, mD001, null, null);
                mv.visitCode();
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, mO001, mN001, mD001, false);
                mv.visitInsn(Opcodes.DRETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            if (!foundM002)
            {
                MethodVisitor mv = this.visitMethod(Opcodes.ACC_PUBLIC, mN002, mD002, null, null);
                mv.visitCode();
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, mO002, mN002, mD002, false);
                mv.visitInsn(Opcodes.IRETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            if (!foundM003)
            {
                MethodVisitor mv = this.visitMethod(Opcodes.ACC_PUBLIC, mN003, mD003, null, null);
                mv.visitCode();
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, mO003, mN003, mD003, false);
                mv.visitInsn(Opcodes.IRETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            if (!foundM004)
            {
                MethodVisitor mv = this.visitMethod(Opcodes.ACC_PUBLIC, mN004, mD004, null, null);
                mv.visitCode();
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, mO004, mN004, mD004, false);
                mv.visitInsn(Opcodes.ARETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            if (!foundM005)
            {
                MethodVisitor mv = this.visitMethod(Opcodes.ACC_PUBLIC, mN005, mD005, null, null);
                mv.visitCode();
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, mO005, mN005, mD005, false);
                mv.visitInsn(Opcodes.IRETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            if (!foundM006)
            {
                MethodVisitor mv = this.visitMethod(Opcodes.ACC_PUBLIC, mN006, mD006, null, null);
                mv.visitCode();
                mv.visitVarInsn(Opcodes.ALOAD, 0);
                mv.visitVarInsn(Opcodes.ALOAD, 1);
                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, mO006, mN006, mD006, false);
                mv.visitInsn(Opcodes.IRETURN);
                mv.visitMaxs(2, 2);
                mv.visitEnd();
            }
            super.visitEnd();
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
        {
            if (mN001.equals(name) && mD001.equals(desc))
            {
                foundM001 = true;
                return new method001(super.visitMethod(access, name, desc, signature, exceptions));
            }
            if (mN002.equals(name) && mD002.equals(desc))
            {
                foundM002 = true;
                return new method002(super.visitMethod(access, name, desc, signature, exceptions));
            }
            if (mN003.equals(name) && mD003.equals(desc))
            {
                foundM003 = true;
                return new method003(super.visitMethod(access, name, desc, signature, exceptions));
            }
            if (mN004.equals(name) && mD004.equals(desc))
            {
                foundM004 = true;
                return new method004(super.visitMethod(access, name, desc, signature, exceptions));
            }
            if (mN005.equals(name) && mD005.equals(desc))
            {
                foundM005 = true;
                return new method005(super.visitMethod(access, name, desc, signature, exceptions));
            }
            if (mN006.equals(name) && mD006.equals(desc))
            {
                foundM006 = true;
                return new method006(super.visitMethod(access, name, desc, signature, exceptions));
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }

    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if ("net.minecraft.item.ItemEditableBook".equals(transformedName))
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
