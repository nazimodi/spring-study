package com.java.spring.mvc.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
public class ScanClassUtil {
    public static Set<Class<?>> getClasses(String packageName) {
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        boolean recursive = true;
        String packageDirName = packageName.replace(".", "/");
        Enumeration<URL> dirs;

        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    System.err.println("file type file scanned");
                    String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                    findAndAddClassedInPackageByFile(packageName, filePath, recursive, classes);

                } else if ("jar".equals(protocol)) {
                    System.err.println("jar type file scanned");
                    JarFile jarFile;
                    jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry jarEntry = entries.nextElement();
                        String name = jarEntry.getName();
                        if (name.charAt(0) == '/') {
                            name = name.substring(1);
                        }
                        if (name.startsWith(packageDirName)) {
                            int idx = name.lastIndexOf('/');
                            if (idx != -1) {
                                packageName = name.substring(0, idx).replace('/', '.');
                            }

                            if ((idx != -1) || recursive) {
                                if (name.endsWith(".class") && !jarEntry.isDirectory()) {
                                    String className = name.substring(packageName.length() + 1, name.length() - 6);
                                    try {
                                        classes.add(Class.forName(packageName + "." + className));
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    /**
     * 获取包下所有class
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    private static void findAndAddClassedInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        File[] dirFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return recursive && pathname.isDirectory() || pathname.getName().endsWith(".class");
            }
        });
        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findAndAddClassedInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);

            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
