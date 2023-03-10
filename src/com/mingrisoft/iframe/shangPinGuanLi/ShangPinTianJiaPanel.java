package com.mingrisoft.iframe.shangPinGuanLi;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import com.mingrisoft.Item;
import com.mingrisoft.dao.Dao;
import com.mingrisoft.dao.model.TbSpinfo;
public class ShangPinTianJiaPanel extends JPanel {// 商品添加面板

    private JComboBox gysQuanCheng;
    private JTextField beiZhu;
    private JTextField wenHao;
    private JTextField piHao;
    private JTextField baoZhuang;
    private JTextField guiGe;
    private JTextField danWei;
    private JTextField chanDi;
    private JTextField jianCheng;
    private JTextField quanCheng;
    private JButton resetButton;

    public ShangPinTianJiaPanel() {// 商品添加面板
        setLayout(new GridBagLayout());// 设置商品添加面板的布局为网格布局
        setBounds(10, 10, 550, 400);// 设置商品添加面板的位置与宽高
        //商品名称
        setupComponent(new JLabel("商品名称："), 0, 0, 1, 1, false);
        quanCheng = new JTextField();// “商品名称”文本框
        setupComponent(quanCheng, 1, 0, 3, 1, true);
        //简称
        setupComponent(new JLabel("简称："), 0, 1, 1, 1, false);
        jianCheng = new JTextField();// “简称”文本框
        setupComponent(jianCheng, 1, 1, 3, 10, true);
        //产地
        setupComponent(new JLabel("产地："), 0, 2, 1, 1, false);
        chanDi = new JTextField();// “产地”文本框
        setupComponent(chanDi, 1, 2, 3, 300, true);
        //单位
        setupComponent(new JLabel("单位："), 0, 3, 1, 1, false);
        danWei = new JTextField();// “单位”文本框
        setupComponent(danWei, 1, 3, 1, 130, true);
        //规格
        setupComponent(new JLabel("规格："), 2, 3, 1, 1, false);
        guiGe = new JTextField();// “规格”文本框
        setupComponent(guiGe, 3, 3, 1, 1, true);
        //包装
        setupComponent(new JLabel("包装："), 0, 4, 1, 1, false);
        baoZhuang = new JTextField();// “包装”文本框
        setupComponent(baoZhuang, 1, 4, 1, 1, true);
        //批号
        setupComponent(new JLabel("批号："), 2, 4, 1, 1, false);
        piHao = new JTextField();// “批号”文本框
        setupComponent(piHao, 3, 4, 1, 1, true);
        //批准文号
        setupComponent(new JLabel("批准文号："), 0, 5, 1, 1, false);
        wenHao = new JTextField();// “批准文号”文本框
        setupComponent(wenHao, 1, 5, 3, 1, true);
        //供应商全称
        setupComponent(new JLabel("供应商全称："), 0, 6, 1, 1, false);
        gysQuanCheng = new JComboBox();// “供应商全称”下拉列表
        gysQuanCheng.setMaximumRowCount(5);// 设置“供应商全称”下拉列表显示的最大行数
        setupComponent(gysQuanCheng, 1, 6, 3, 1, true);
        //备注
        setupComponent(new JLabel("备注："), 0, 7, 1, 1, false);
        beiZhu = new JTextField();// “备注”文本框
        setupComponent(beiZhu, 1, 7, 3, 1, true);
        final JButton tjButton = new JButton();// “添加”按钮
        tjButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                // 文本框为空时，弹出提示框
                if (baoZhuang.getText().equals("") || chanDi.getText().equals("") || danWei.getText().equals("")
                        || guiGe.getText().equals("") || jianCheng.getText().equals("") || piHao.getText().equals("")
                        || wenHao.getText().equals("") || quanCheng.getText().equals("")) {
                    JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "请完成未填写的信息。",
                            "商品添加", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // 执行SQL查询语句获得的结果集
                ResultSet haveUser = Dao.query("select * from tb_spinfo where spname='"+quanCheng.getText().trim()+"'");
                try {
                    if (haveUser.next()) {// 结果集haveUser中有超过一条的记录
                        System.out.println("error");// 控制台输出error
                        // 弹出提示框
                        JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this,
                                "商品信息添加失败，存在同名商品", "客户添加信息", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                } catch (Exception er) {
                    er.printStackTrace();
                }
                ResultSet set = Dao.query("select max(id) from tb_spinfo");// 执行SQL查询语句获得的结果集
                String id = null;// 声明产品编号
                try {
                    if (set != null && set.next()) {// 结果集set不为空且结果集set中有超过一条的记录
                        String sid = set.getString(1);// 获得结果集set中的第一列数据值
                        if (sid == null)// 第一列数据值为空
                            id = "sp1001";// 为产品编号赋值
                        else {
                            String str = sid.substring(2);// 从索引为2处开始截取字符串
                            id = "sp" + (Integer.parseInt(str) + 1);// 重新拼接字符串获得产品编号
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                TbSpinfo spInfo = new TbSpinfo();
                spInfo.setId(id);
                spInfo.setBz(baoZhuang.getText().trim());
                spInfo.setCd(chanDi.getText().trim());
                spInfo.setDw(danWei.getText().trim());
                spInfo.setGg(guiGe.getText().trim());
                spInfo.setGysname(gysQuanCheng.getSelectedItem().toString().trim());
                spInfo.setJc(jianCheng.getText().trim());
                spInfo.setMemo(beiZhu.getText().trim());
                spInfo.setPh(piHao.getText().trim());
                spInfo.setPzwh(wenHao.getText().trim());
                spInfo.setSpname(quanCheng.getText().trim());
                Dao.addSp(spInfo);
                JOptionPane.showMessageDialog(ShangPinTianJiaPanel.this, "商品信息已经成功添加",
                        "商品添加", JOptionPane.INFORMATION_MESSAGE);
                resetButton.doClick();// “重置”按钮执行点击事件
            }
        });
        //添加
        tjButton.setText("添加");
        setupComponent(tjButton, 1, 8, 1, 1, false);
        final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();// 创建网格限制对象
        gridBagConstraints_20.weighty = 1.0;// “添加”按钮纵向扩大的权重是1.0
        gridBagConstraints_20.insets = new Insets(0, 65, 0, 15);// “添加”按钮与其他组件彼此的间距
        gridBagConstraints_20.gridy = 8;// “添加”按钮位于网格的纵向索引为8
        gridBagConstraints_20.gridx = 1;// “添加”按钮位于网格的横向索引为1
        resetButton = new JButton();// “重置”按钮
        setupComponent(resetButton, 3, 8, 1, 1, false);// 设置“重置”按钮的位置并添加到容器中
        resetButton.addActionListener(new ActionListener() {// “重置”按钮动作事件的监听
            public void actionPerformed(final ActionEvent e) {
                // 设置文本框的内容为空
                baoZhuang.setText("");
                chanDi.setText("");
                danWei.setText("");
                guiGe.setText("");
                jianCheng.setText("");
                beiZhu.setText("");
                piHao.setText("");
                wenHao.setText("");
                quanCheng.setText("");
            }
        });
        resetButton.setText("重置");// 设置“重置”按钮中的文本内容
    }
    // 设置组件的位置并添加到容器中
    private void setupComponent(JComponent component, int gridx, int gridy, int gridwidth, int ipadx, boolean fill) {
        final GridBagConstraints gridBagConstrains = new GridBagConstraints();// 创建网格限制对象
        gridBagConstrains.gridx = gridx;// 设置组件位于网格的横向索引为gridx
        gridBagConstrains.gridy = gridy;// 设置组件位于网格的纵向索引为gridy
        gridBagConstrains.insets = new Insets(5, 1, 3, 1);// 组件彼此的间距
        if (gridwidth > 1)// 组件横跨网格数大于1
            gridBagConstrains.gridwidth = gridwidth;// 设置组件横跨网格数为gridwidth
        if (ipadx > 0)// 组件横向填充的大小大于0
            gridBagConstrains.ipadx = ipadx;// 设置组件横向填充的大小
        if (fill)// 组件占据空白区域
            gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;// 组件水平扩大以占据空白区域
        add(component, gridBagConstrains);// 添加组件
    }
    // 初始化供应商下拉选择框
    public void initGysBox() {
        List gysInfo = Dao.getGysInfos();// 获取供应商信息
        List<Item> items = new ArrayList<Item>();// 创建数据公共表的集合
        gysQuanCheng.removeAllItems();// 移除下拉列表中现有的供应商全称
        for (Iterator iter = gysInfo.iterator(); iter.hasNext();) {// 遍历list集合
            List element = (List) iter.next();// 获得集合中下一个元素
            Item item = new Item();
            item.setId(element.get(0).toString().trim());// 设置编号属性
            item.setName(element.get(1).toString().trim());// 设置名称信息
            if (items.contains(item))// 集合中包含数据表公共类对象
                continue;// 跳过本次循环
            items.add(item);// 集合中不包含数据表公共类对象，项集合中添加数据表公共类对象
            gysQuanCheng.addItem(item);// 项下拉列表中添加数据表公共类对象
        }
    }
}