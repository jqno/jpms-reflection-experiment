package com.example.self;

import com.example.external.External;

public class Self {
    public static void main(String[] args) throws Exception {
        var publicSelf = Self.class.getDeclaredMethod("callPublic");
        publicSelf.invoke(null);

        var packageProtectedSelf = Self.class.getDeclaredMethod("callPackageProtected");
        packageProtectedSelf.invoke(null);

        var publicExternal = External.class.getDeclaredMethod("callPublic");
        publicExternal.invoke(null);

        var packageProtectedExternal = External.class.getDeclaredMethod("callPackageProtected");
        packageProtectedExternal.setAccessible(true);
        packageProtectedExternal.invoke(null);
    }


    public static void callPublic() {
        System.out.println("Called public method in Self");
    }

    static void callPackageProtected() {
        System.out.println("Called package protected method in Self");
    }
}

