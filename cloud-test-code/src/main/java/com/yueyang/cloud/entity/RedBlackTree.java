package com.yueyang.cloud.entity;

import java.util.HashMap;

/**
 * @program: cloud-consumerconsul-order80
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-24 06:34
 **/
public class RedBlackTree {

    private final int R = 0;
    private final int B = 1;
    /**
     * //红黑树的根节点
     */
    private Node root = null;

    class Node {
        int data;//存的数据
        int color = R;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    //插入部分
    public void insert(Node root, int data) {
        //root结点一定不为空，最开始就默认进去
        if (root.data <= data) {
            //表示插入右边
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        } else {
            //表示插入左边
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        }
    }


    public void leftRotate(Node node) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

    }
}