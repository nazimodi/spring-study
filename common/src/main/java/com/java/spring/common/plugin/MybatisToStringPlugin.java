package com.java.spring.common.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

/**
 * @author renqingwang on 2017/9/12.
 * @version 1.0
 */
public class MybatisToStringPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateToString(introspectedTable, topLevelClass);
        return true;
    }

    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateToString(introspectedTable, topLevelClass);
        return true;
    }

    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateToString(introspectedTable, topLevelClass);
        return true;
    }

    public void generateToString(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
        //首先创建一个Method对象，注意，这个Method是org.mybatis.generator.api.dom.java.Method，
        //这个Method是MBG中对对象DOM的一个抽象；因为我们要添加方法，所以先创建一个；
        Method method = new Method();

        //设置这个方法的可见性为public，代码已经在一步一步构建这个方法了
        method.setVisibility(JavaVisibility.PUBLIC);

        //设置方法的返回类型，这里注意一下的就是，returnType是一个FullyQualifiedJavaType；
        //这个FullyQualifiedJavaType是MGB中对Java中的类型的一个DOM封装，这个类在整个MBG中大量使用；
        //FullyQualifiedJavaType提供了几个静态的方法，比如getStringInstance，就直接返回了一个对String类型的封装；
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());

        //设置方法的名称，至此，方法签名已经装配完成；
        method.setName("toString");//$NON-NLS-1$

        //判断当前MBG运行的环境是否支持Java5（这里就可以看出来IntrospectedTable类的作用了，主要是查询生成环境的作用）
        if (introspectedTable.isJava5Targeted()) {
            //如果支持Java5，就在方法上面生成一个@Override标签；
            method.addAnnotation("@Override");//$NON-NLS-1$
        }

        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

        method.addBodyLine("StringBuilder sb = new StringBuilder();");//$NON-NLS-1$
        method.addBodyLine("sb.append(getClass().getSimpleName());");//$NON-NLS-1$
        method.addBodyLine("sb.append(\" [\");");//$NON-NLS-1$
        method.addBodyLine("sb.append(\"Hash = \").append(hashCode());");//$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        for (Field field : topLevelClass.getFields()) {
            String property = field.getName();
            sb.setLength(0);
            sb.append("sb.append(\", ").append(property)//$NON-NLS-1$ //$NON-NLS-2$
                    .append("=\")").append(".append(").append(property) //$NON-NLS-1$ //$NON-NLS-2$
                    .append(");");//$NON-NLS-1$
            method.addBodyLine(sb.toString());
        }
        method.addBodyLine("sb.append(\"]\");"); //$NON-NLS-1$
        method.addBodyLine("return sb.toString();"); //$NON-NLS-1$

        //把拼装好的方法DOM添加到topLevelClass中，完成方法添加；
        topLevelClass.addMethod(method);
    }
}
