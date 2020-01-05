package com.shuonai.gm.util.leetCode;

import java.util.*;

class Solution {
//    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//    示例 1:
//
//    输入: "Let's take LeetCode contest"
//    输出: "s'teL ekat edoCteeL tsetnoc" 

    public static void main(String[] args){
        Solution ss = new Solution();
        String str = "Let's take LeetCode contest";
//        System.out.println(str);
        str = ss.reverseWords(str);
        System.out.println(str);
    }
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String word : ss){
            sb.append(reverseString2(word.toCharArray())+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public String reverseString2(char[] s) {
        char x;
        for(int i = 0;i<s.length/2;i++){
            x = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = x;
        }
        return String.valueOf(s);
    }
//    public static void main(String[] args){
//        Solution ss = new Solution();
//        char[] arr = {'h','e','l','l','o'};
//        System.out.println(arr);
//        ss.reverseString(arr);
//        System.out.println(arr);
//    }
    public void reverseString(char[] s) {
        char x;
        for(int i = 0;i<s.length/2;i++){
            x = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = x;
        }
    }
//    你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
//
//    你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
//
//    示例:
//
//    输入: 4
//    输出: false
//    解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
//                 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。

//    public static void main(String[] args){
//        Solution ss = new Solution();
//        int n = 9;
//        System.out.println(n%4);
//    }
    //保留剩下4个的倍数给朋友拿
    public boolean canWinNim(int n) {
//        n/4
//        return n % 4 == 0 ? false : true;
        return (n % 4 != 0);
    }
//    public static void main(String[] args){
//        Solution ss = new Solution();
//
//    }
    //正一遍，反一遍，2n也是O(n)复杂度
    public int[] productExceptSelf(int[] nums) {
//        1,1,2,6
//        24,12,4,1
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0;i<nums.length;i++){
            res[i] = k;
            k = k*nums[i];
        }
        k = 1;
        for(int i = nums.length-1;i>0;i--){
            res[i] = nums[i]*k;
            k = k*nums[i];
        }
        return res;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//
//        ListNode a = new ListNode(4);
//        ListNode b = new ListNode(5);
//        ListNode c = new ListNode(1);
//        ListNode d = new ListNode(9);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = null;
//        s.deleteNode(a,b);
//
//    }
    public void deleteNode(ListNode a,ListNode node) {
//        node.next = node;
        node.val = node.next.val;
        node.next = node.next.next;
        System.out.println(a);
        System.out.println(node);
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
////        TreeNode a = new TreeNode(1);
////        TreeNode b = new TreeNode(2);
////        a.left = b;
//        TreeNode a = new TreeNode(3);
//        TreeNode b = new TreeNode(5);
//        TreeNode c = new TreeNode(1);
//        TreeNode d = new TreeNode(6);
//        TreeNode e = new TreeNode(2);
//        TreeNode f = new TreeNode(0);
//        TreeNode g = new TreeNode(8);
//        TreeNode h = new TreeNode(7);
//        TreeNode i = new TreeNode(4);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;
//        e.left = h;
//        e.right = i;
//        System.out.println(s.lowestCommonAncestor(a,d,i).val);
//
//    }
    public TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        lowestCommonAncestor2(root,p,q);
        return result;
    }
    //递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(result != null){return null;}
//        if(root == p){return root;}else if(root == q){return root;}
        if(root != null){
            TreeNode pp = lowestCommonAncestor2(root.left,p,q);
            TreeNode qq = lowestCommonAncestor2(root.right,p,q);
            if(root == p && pp == null){pp = root;}else if(root == p && qq == null){qq = root;}
            if(root == q && pp == null){pp = root;}else if(root == q && qq == null){qq = root;}
            if(pp != null && qq != null && pp != qq){result = root;return null;}
            return pp == null ? qq : pp;
        }
        return null;
    }
//    public boolean pp = false;
//    public static void main(String[] args){
//        Solution s = new Solution();
//        int inParam = 512;
//        System.out.println(s.isPowerOfTwo(inParam));
//
//    }
    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        int min = p.val < q.val ? p.val : q.val;
        int max = p.val < q.val ? q.val : p.val;
        while(true){
            if(root.val >= min && root.val <= max){
                return root;
            }else if(root.val > max){
                root = root.left;
            }else if(root.val <min){
                root = root.right;
            }else{
                break;
            }
        }
        return null;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        int inParam = 512;
//        System.out.println(s.isPowerOfTwo(inParam));
//
//    }
    //运算符 与（&）、非（~）、或（|）、异或（^）
//    位异或运算（^）
//    运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
//    位与运算符（&）
//    运算规则：两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。
//    位或运算符（|）
//    运算规则：两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。
//    位非运算符（~）
//    运算规则：如果位为0，结果是1，如果位为1，结果是0.
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
    //常规思路
    public boolean isPowerOfTwo(int n) {
        if(n<0){return false;}
        double n2 = 0;
        for(int i = 0;n2<n;i++){
            n2 = Math.pow(2,i);
            if(n2==n){
                return true;
            }
        }
        return false;
    }
//    给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//
//    说明：
//    你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//
//    示例 1:
//
//    输入: root = [3,1,4,null,2], k = 1
//             3
//            / \
//           1   4
//            \
//            2
//    输出: 1

//    public static void main(String[] args){
//        Solution s = new Solution();
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        a.left = b;
//        a.right = c;
//        TreeNode a = new TreeNode(5);
//        TreeNode b = new TreeNode(3);
//        TreeNode c = new TreeNode(6);
//        TreeNode d = new TreeNode(2);
//        TreeNode e = new TreeNode(4);
//        TreeNode f = new TreeNode(1);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        d.left = f;
//        System.out.println(s.kthSmallest3(a,2));
//
//    }
    //二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
    // 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    // 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    // 它的左、右子树也分别为二叉排序树。
    private int cnt,ans;
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(--cnt==0)ans=root.val;
        inorder(root.right);
    }

    public int kthSmallest3(TreeNode root, int k) {
        cnt=k;
        inorder(root);
        return ans;
    }
    private static PriorityQueue<TreeNode> heap = new PriorityQueue<TreeNode>(new Comparator<TreeNode>(){ public int compare(TreeNode i1, TreeNode i2) { return i2.val - i1.val;}});
    public void kthSmallest2(TreeNode root,int k) {
        if(root.left != null){
            kthSmallest2(root.left,k);
        }
        if(root.right != null){
            kthSmallest2(root.right,k);
        }
        heap.add(root);
        if (heap.size() > k){
            heap.poll();
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest2(root,k);
        return heap.poll().val;
    }
//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[] arr = {1,2,3,1};
////        System.out.println(s.findKthLargest2(arr,3));
//        System.out.println(s.containsDuplicate(arr));
//    }

    public boolean containsDuplicate(int[] nums) {
        int x = nums[0];
        int p = 0;
        for(int i = 1;i<nums.length;i++){
            x = nums[i]^x;
            if(p == x){
                return true;
            }else{
                p = x;
            }
        }
        return false;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[] arr = {3,2,1,5,6,4};
////        System.out.println(s.findKthLargest2(arr,3));
//        System.out.println(1^1);
//        int x = arr[0];
//        int p = 0;
//        for(int i = 1;i<arr.length;i++){
//            x = arr[i]^x;
//            if(p == x){
//                return true;
//            }else{
//                p = x;
//            }
//        }
//        return false;
//    }


    public int findKthLargest2(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer i1, Integer i2) {
                        return i1 - i2;
                    }
                });
        PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>();

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        ListNode a = new ListNode(4);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(1);
//        ListNode d = new ListNode(3);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        ListNode result = s.reverseList2(a);
//        while(result != null){
//            System.out.print(result.val);
//            result = result.next;
//        }
//    }
    //递归
    public ListNode reverseList2(ListNode head) {
        if(head == null){return null;}
        ListNode now = head;
        ListNode next;
        if(now.next != null){
            next = reverseList2(now.next);
            now.next.next = now;
            now.next = null;
            return next;
        }
        return now;
    }
    //迭代
    public ListNode reverseList(ListNode head) {
        if(head == null){return null;}
        ListNode pre = null;
        ListNode now = head;
        ListNode next = head.next;
        while(next != null){
            now.next = pre;
            pre = now;
            now = next;
            next = next.next;
        }
        now.next = pre;
        return now;
    }

//    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在众数。
//
//    示例 1:
//
//    输入: [3,2,3]
//    输出: 3


//    public static void main(String[] args){
//        int[] arr = {3,2,3,3,3,2};
//        Solution s = new Solution();
//        System.out.println(s.majorityElement3(arr));
//    }
    //投票
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer nowNum = null;
        for(int num : nums){
            if (nowNum == null || count == 0){
                nowNum = num;
                count = 1;
                continue;
            }
            count += (nowNum != num ? -1 : 1);
        }
        return  nowNum;
    }
    //排序

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //哈希
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }


//    public static void main(String[] args){
//        Solution s = new Solution();
//        ListNode a = new ListNode(4);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(1);
//        ListNode d = new ListNode(3);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        System.out.println(s.sortList(a));
//    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ArrayList list = new ArrayList();
//        while(headA != null || headB != null){
//            if(headA != null){
//                if(!list.contains(headA)){
//                    list.add(headA);
//                    headA = headA.next;
//                }else{
//                    return headA;
//                }
//            }
//            if(headB != null){
//                if(!list.contains(headB)){
//                    list.add(headB);
//                    headB = headB.next;
//                }else{
//                    return headB;
//                }
//            }
//        }
//        return null;

        ListNode a = headA;
        ListNode b = headB;
//        boolean tipA = true;
//        boolean tipB = true;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
//            if (a == null && tipA){a = headB;tipA = false;}
//            if (b == null && tipB){b = headA;tipB = false;}
        }
        return a;
    }

//    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
//    示例 1:
//
//    输入: 4->2->1->3
//    输出: 1->2->3->4
//    public static void main(String[] args){
//        Solution s = new Solution();
//        ListNode a = new ListNode(4);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(1);
//        ListNode d = new ListNode(3);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        System.out.println(s.sortList(a));
//    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        ListNode a = new ListNode(3);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(0);
//        ListNode d = new ListNode(-4);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = b;
//        System.out.println(s.detectCycle(a));
//    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){return null;}
        ListNode s = head.next;
        ListNode f = head.next.next;
        while(s != f){
            if(f.next == null || f.next.next == null){
                return null;
            }else{
                s = s.next;
                f = f.next.next;
            }
        }
        ListNode first = head;
        while(s != first){
            first = first.next;
            s = s.next;
        }
        return first;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        ListNode a = new ListNode(3);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(0);
//        ListNode d = new ListNode(-4);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = b;
//        System.out.println(s.hasCycle2(a));
//    }

    //方法一：哈希表
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
    //方法二：双指针
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null){return false;}
        ListNode s = head;
        ListNode f = head.next;
        while(s != f){
            if(f.next == null || f.next.next == null){
                return false;
            }else{
                s = s.next;
                f = f.next.next;
            }
        }
        ListNode first = head;
        while(s != first){
            first = first.next;
            s = s.next;
        }
        return true;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[] arr = {4,1,2,1,2};
//        System.out.println(s.singleNumber(arr));
//    }
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        TreeNode a = new TreeNode(-10);
//        TreeNode b = new TreeNode(-2);
//        TreeNode c = new TreeNode(-3);
////        TreeNode e = new TreeNode(2);
////        TreeNode f = new TreeNode(5);
////        TreeNode g = new TreeNode(6);
////        TreeNode h = new TreeNode(7);
//        a.left = b;
//        a.right = c;
////        c.left = e;
////        c.right = f;
////        b.left = g;
////        b.right = h;
//        System.out.println(s.maxPathSum(a));
//    }

    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;
        int left_gain = Math.max(max_gain(node.left),0);
        int right_gain = Math.max(max_gain(node.right),0);
        int maxGain = node.val + left_gain + right_gain;
//        max_sum = max_sum < maxGain ? maxGain : max_sum;
        max_sum = Math.max(max_sum,maxGain);
//        return node.val = left_gain > right_gain ? node.val + left_gain : node.val + right_gain;
        return node.val = node.val + Math.max(left_gain,right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
    public int maxPathSum2(TreeNode root) {
        if(root == null){return 0;}
        int result = root.val;
        TreeNode t = root;
        while(root.right != null || root.left != null){
            t = testNode(root);
            if((t.left == null || t.left.left == null) && (t.right == null || t.right.right == null)){
                int left = 0;
                int right = 0;
                int max = returnMax(t);
                result = max > result ? max : result;
                if(t.left != null && t.left.val > 0){left = t.left.val;}
                if(t.right != null && t.right.val > 0){right = t.right.val;}
                if(left > right){
                    t.val += left;
                }else{
                    t.val += right;
                }
                t.left = null;
                t.right = null;
            }

        }
        System.out.println(root.val);
        System.out.println(result);
        return result;
    }

    public int returnMax(TreeNode root){
        int max = root.val;
        if(root.left != null){
            max = max > root.left.val ? max : root.left.val;
            max = max > root.left.val + root.val ? max : root.left.val + root.val;
        }
        if(root.right != null){
            max = max > root.right.val ? max : root.right.val;
            max = max > root.right.val + root.val ? max : root.right.val + root.val;
        }
        if(root.left != null && root.right != null){
            max = max > root.right.val + root.left.val + root.val ? max : root.right.val + root.left.val + root.val;
        }
        return max;
    }
    public TreeNode testNode(TreeNode root){
        if(root.left != null && (root.left.left != null || root.left.right != null)){
            return testNode(root.left);
        }else if(root.right != null && (root.right.left != null || root.right.right != null)){
            return testNode(root.right);
        }
        return root;
    }

//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    示例 1:
//
//    输入: [7,1,5,3,6,4]
//    输出: 7
//    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//                 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

//    public static void main(String[] args){
//        Solution s = new Solution();
////        int[] arr = {7,1,5,3,6,4,9};
//        int[] arr = {1,2,3,4,5};
//        System.out.println(s.maxProfit2(arr));
//    }

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0){return 0;}
        int sum = 0;
        int in = prices[0];
        for(int i = 1;i<prices.length;i++){
            int diff = prices[i] - prices[i - 1];
            if(diff > 0){
                sum += diff;
            }
        }
        return sum;
    }

//    输入: [7,1,5,3,6,4]
//    输出: 5
//    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[] arr = {7,1,5,3,6,4,9};
//        System.out.println(s.maxProfit(arr));
//    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){return 0;}
        int result = 0;
        int in = prices[0];
        for(int i = 1;i<prices.length;i++){
            if(in < prices[i]){
                if(result < prices[i] - in){
                    result = prices[i] - in;
                }
            }else if(in > prices[i]){
                in = prices[i];
            }
        }
        return result;
    }
//    给定二叉树 [3,9,20,null,null,15,7]，
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    返回它的最大深度 3 。

//    public static void main(String[] args){
//        Solution s = new Solution();
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode e = new TreeNode(4);
//        TreeNode f = new TreeNode(5);
//        a.left = b;
//        a.right = c;
//        c.left = e;
//        c.right = f;
//        System.out.println(s.maxDepth(a));
//        System.out.println(s.maxDepth2(a));
//    }

    public int maxDepth2(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
    public int maxDepth(TreeNode root) {
        if(root == null){return 0;}
        List<TreeNode> nodes = new ArrayList<TreeNode>(){{add(root);}};
        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        int result = 0;
        do {
            if (newNodes != null) {
                newNodes = new ArrayList<TreeNode>();
            }
            result++;
            for (TreeNode n : nodes) {
                if (n.left != null) {
                    newNodes.add(n.left);
                }
                if (n.right != null) {
                    newNodes.add(n.right);
                }
            }
            nodes = newNodes;
        }while (newNodes.size() != 0);
        return result;
    }

//    格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//
//    给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
//
//    示例 1:
//
//    输入: 2
//    输出: [0,1,3,2]
//    解释:
//            00 - 0
//            01 - 1
//            11 - 3
//            10 - 2
//    public static void main(String[] args){
//        Solution s = new Solution();
//        List<Integer> result = s.grayCode(6);
//        for(Integer r : result){
//            System.out.print(r+" ");
//        }
//    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>(){{add(0);}};
        for(int i = 0;i<n;i++){
            for(int j = result.size()-1;j>=0;j--){
                result.add(result.get(j)+(int)Math.pow(2, i));
            }
        }
        return result;
    }

//    输入:
//    nums1 = [1,2,3,0,0,0], m = 3
//    nums2 = [2,5,6],       n = 3
//
//    输出: [1,2,2,3,5,6]
//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        s.merge(nums1,3,nums2,3);
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0;
        int b = 0;
        int[] result = new int[m+n];
        for(int i = 0;i<nums1.length;i++){
            result[i] = nums1[i];
        }
        for(int i = 0;i<m+n;i++){
            if((a<m && b<n && result[a] <= nums2[b]) || (b == n && a < m)){
                nums1[i] = result[a];
                a++;
            }else if((a<m && b<n && result[a] > nums2[b]) || (a == m && b < n)){
                nums1[i] = nums2[b];
                b++;
            }
        }
    }

//    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//    说明：解集不能包含重复的子集。
//
//    示例:
//
//    输入: nums = [1,2,3]
//    输出:
//            [
//            [3],
//              [1],
//              [2],
//              [1,2,3],
//              [1,3],
//              [2,3],
//              [1,2],
//              []
//            ]

//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[] arr = {1,2,3};
//        List<List<Integer>> result = s.subsets(arr);
//        for(List<Integer> rr : result){
//            for(Integer r : rr){
//                System.out.print(r+" ");
//            }
//            System.out.println();
//        }
//    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int[] arr = new int[nums.length];
        for(int i = 0;i<arr.length;i++){
            arr[i] = 0;
        }
        for(int n = 0;n<2<<nums.length-1;n++){
            List<Integer> r =  new ArrayList();
            for(int i = 0;i<nums.length;i++){
                if(arr[i] == 1){
                    r.add(nums[i]);
                }
            }
            result.add(r);
            for(int i = 0;i<arr.length;i++){
                if(arr[i] == 0){
                    arr[i] = 1;
                    break;
                }else{
                    arr[i] = 0;
                }
            }
        }
        return result;
    }
    public static int[] arrAA(int[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                arr[i] = 1;
                break;
            }else{
                arr[i] = 0;
            }
        }
        return arr;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//
//        System.out.println(s.climbStairs(7));
//    }
    public int climbStairs(int n) {
        int result = 0;
        int a = 0;
        int b = 1;
        for(int i = 0;i<n;i++){
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

//    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//    注意：给定 n 是一个正整数。
//
//    示例 1：
//
//    输入： 2
//    输出： 2
//    解释： 有两种方法可以爬到楼顶。
//    1.  1 阶 + 1 阶
//    2.  2 阶
//    示例 2：
//
//    输入： 3
//    输出： 3
//    解释： 有三种方法可以爬到楼顶。
//    1.  1 阶 + 1 阶 + 1 阶
//    2.  1 阶 + 2 阶
//    3.  2 阶 + 1 阶


//    public static void main(String[] args){
//        Solution s = new Solution();
//        s.uniquePaths2(5,5);
//    }

    public int uniquePaths2(int m, int n) {
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    res[0][j] = 1;
                else if (j == 0)
                    res[i][0] = 1;
                else
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        for(int[] r :res ){
            for(int rr :r){
                System.out.print(" "+rr);
            }
            System.out.println();
        }
        return res[m - 1][n - 1];

    }
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){return 1;}
        int sum = (m+n-2);
        long c = 1;
        long a = 1;
        int k = 0;
        if(m>n){k = n;}else{k = m;}
        for(int i = 0;i<k-1;i++){
            c = c*(sum-i);
            a = a*(i+1);
        }
        System.out.println("c:"+c+"a:"+a);
        System.out.println("c/a:"+c/a);
        long result = c/a;
        return (int)result;
    }

//    输入: 1->2->3->4->5->NULL, k = 2
//    输出: 4->5->1->2->3->NULL
//    解释:
//    向右旋转 1 步: 5->1->2->3->4->NULL
//    向右旋转 2 步: 4->5->1->2->3->NULL
//    public static void main(String[] args){
//        Solution s = new Solution();
//        ListNode lna1 = new ListNode(1);
////        ListNode lna2 = new ListNode(4);
////        ListNode lna3 = new ListNode(5);
////        lna1.next = lna2;
////        lna2.next = lna3;
//        s.rotateRight(lna1,1);
//    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){return null;}
        if(k == 0){return head;}
        List<ListNode> nodes = new ArrayList<ListNode>();
        ListNode ln = head;
        while(ln.next != null){
            nodes.add(ln);
            ln = ln.next;
        }
        nodes.add(ln);
        if(nodes.size() <= k){
            k = k%nodes.size();
        }
        ln.next = nodes.get(0);
        ListNode lastNode = nodes.get(nodes.size()-k-1);
        ListNode resultNode = lastNode.next;
        lastNode.next = null;
        return resultNode;
    }

//    输入: 3
//    输出:
//            [
//            [ 1, 2, 3 ],
//            [ 8, 9, 4 ],
//            [ 7, 6, 5 ]
//            ]

//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[][] result = s.generateMatrix(4);
//        for(int[] r : result){
//            for(int rr : r){
//                System.out.print(rr);
//            }
//            System.out.println();
//        }
//    }

    public int[][] generateMatrix(int n) {
//        List<Integer> result = new ArrayList<Integer>();
        int z = 0;
        int num = 0;
        int xNow = n;
        int yNow = n;
        int[][] result = new int[n][n] ;
        for(int i = 0;i<yNow;i++){
            if(i <= yNow - 1 -z) {
                for (int j = z; j < xNow - z; j++) {
//                System.out.println(matrix[i][j]);
                    num++;
//                    result.add(matrix[i][j]);
                    result[i][j] = num;
                    if (j == xNow - 1 - z) {
                        for (int k = 1 + z; k < yNow - z; k++) {
//                        System.out.println(matrix[k][j]);
//                            result.add(matrix[k][j]);
                            num++;
                            result[k][j] = num;
                            if (k == yNow - 1 - z) {
                                for (int l = xNow - 1 - 1 - z; l >= z; l--) {
//                                System.out.println(matrix[k][l]);
//                                    result.add(matrix[k][l]);
                                    num++;
                                    result[k][l] = num;
                                    if (l == z) {
                                        for (int m = yNow - 1 - 1 - z; m > z; m--) {
//                                        System.out.println(matrix[m][l]);
//                                            result.add(matrix[m][l]);
                                            num++;
                                            result[m][l] = num;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                z++;
            }
        }
        System.out.println(result.toString());
        return result;
    }

//    输入:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    输出: [1,2,3,6,9,8,7,4,5]

//    public static void main(String[] args){
//        Solution s = new Solution();
////        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{2,5,8},{4,0,-1}};
////        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        s.spiralOrder(matrix);
//    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0){return result;}
        int z = 0;
        int xNow = matrix[0].length;
        int yNow = matrix.length;
//        int xNum = matrix[0].length;
//        int yNum = matrix.length;
        for(int i = 0;i<yNow;i++){
            if(i <= yNow - 1 -z) {
                for (int j = z; j < xNow - z; j++) {
//                System.out.println(matrix[i][j]);
                    result.add(matrix[i][j]);
                    if (j == xNow - 1 - z) {
                        for (int k = 1 + z; k < yNow - z; k++) {
//                        System.out.println(matrix[k][j]);
                            result.add(matrix[k][j]);
                            if (k == yNow - 1 - z) {
                                for (int l = xNow - 1 - 1 - z; l >= z; l--) {
//                                System.out.println(matrix[k][l]);
                                    result.add(matrix[k][l]);
                                    if (l == z) {
                                        for (int m = yNow - 1 - 1 - z; m > z; m--) {
//                                        System.out.println(matrix[m][l]);
                                            result.add(matrix[m][l]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                z++;
            }
        }
        System.out.println(result.toString());
        return result;
    }


//    输入: [-2,1,-3,4,-1,2,1,-5,4],
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

//    public static void main(String[] args){
//        Solution s = new Solution();
////        int[] nums = {4,5,6,7,8};
////        int[] nums = {-2,1,-3,4,1};
////        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {8,8,-19,5,-4,20};
////        int[] nums = {0};
//        System.out.println(s.maxSubArray2(nums));
//    }

    public int maxSubArray2(int[] nums) {
        int result = nums[0];   // 保存最大的结果
        int sum = 0;            // 保存当前的子序和

        for (int num : nums) {
            if (sum > 0) {     // sum是正数，意味着后面有机会再创新高，可以继续加
                sum += num;
            } else {           // sum是负的，还不如直接从当前位重新开始算，也比(负数+当前值)要大吧
                sum = num;
            }
            result = Math.max(result, sum);   // 每一步都更新最大值
        }

        return result;
    }
    public int maxSubArray(int[] nums) {
        int result = 0;
        int maxResult = 0;
        boolean ifFrist = true;
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums.length-i;j++){//脚标
                for(int k = j,l = 0;l<=i;k++,l++){
                    result += nums[k];
                }
                System.out.println(result);
                if(ifFrist){
                    maxResult = result;
                    ifFrist = false;
                }else{
                    if(result > maxResult){
                        maxResult = result;
                    }
                }
                result = 0;
            }
        }
        System.out.println("max:"+maxResult);
        return maxResult;
    }


//    public static void main(String[] args){
//        Solution s = new Solution();
//        int[] nums = {4,5,6,7,8};
//        s.permute(nums);
//    }

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){return null;}
        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> tempResult = new ArrayList();
        List<Integer> e = new ArrayList();
        for(int num : nums){
            if(result.size() == 0){
                e.add(num);
                result.add(e);
            }else{
                for(List<Integer> ee : result){
                    for(int i = 0;i<=ee.size();i++){
                        List<Integer> temp = new ArrayList(ee);
                        temp.add(i,num);
                        tempResult.add(temp);
                    }
                }
                result = tempResult;
                tempResult = new ArrayList();
            }
        }
        System.out.println(result.toString());
        return result;
    }






//    输入: num1 = "123", num2 = "456"
//    输出: "56088"

//    public static void main(String[] args){
//        Solution s = new Solution();
////        int sw = 41234/10%10;
////        System.out.println(sw);
////        s.multiply("123456789","987654321");
////        s.multiply5("777","777");
////        System.out.println(s.multiply4("777","777"));
////        s.multiply3("11111122","2222");
////        s.multiply2("1211233","2");
//        String ddsfs = "124124";
//        int dd = ddsfs.charAt(2)-0;
//        int cc = ddsfs.charAt(2)+'0';
//        System.out.println("dd:"+dd);
//        System.out.println("cc:"+cc);
//
//    }
    public String multiply5(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();

    }
    public String multiply4(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){return "0";}
        StringBuffer sba = new StringBuffer(num1);
        StringBuffer sbb = new StringBuffer(num2);
        String[] as = sba.reverse().toString().split("");
        String[] bs = sbb.reverse().toString().split("");
        Map map = new HashMap();
        String azero = "";
        for (String a : as){
            String bzero = "";
            for(String b : bs){
                if(map.get(azero+bzero) == null){
                    map.put(azero+bzero,Integer.parseInt(a)*Integer.parseInt(b));
                }else{
                    map.put(azero+bzero,Integer.parseInt(map.get(azero+bzero).toString())+Integer.parseInt(a)*Integer.parseInt(b));
                }
                bzero = "0"+bzero;
            }
            azero = "0"+azero;
        }
        StringBuffer sb = new StringBuffer();
        String k = "";
        int temp = 0;
        do{
            int aaa = Integer.parseInt(map.get(k).toString()) + temp;
            int g = aaa%10;
            sb.insert(0,g);
            int sw = aaa/10;
            temp = sw;
            k = "0"+k;
        }while(map.get(k) != null);
        if(temp != 0){sb.insert(0,temp+"");}
        return sb.toString();
    }

//    public static void main(String[] args){
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 6;
//        Solution s = new Solution();
//        int result = s.search(nums,target);
//        System.out.println(result);
//    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length <= 0){
            return -1;
        }
        if(nums[0] < target){
            for(int i = 1;i < nums.length;i++){
                if(nums[i] < target){
                    continue;
                }else if(nums[i] > target){
                    return -1;
                }else{
                    return i;
                }
            }
            return -1;
        }else if(nums[0] > target){
            for(int i = nums.length-1;i > 0;i--){
                if(nums[i] > target){
                    continue;
                }else if(nums[i] < target){
                    return -1;
                }else{
                    return i;
                }
            }
            return -1;
        }else{
            return 0;
        }
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        ListNode lna1 = new ListNode(1);
//        ListNode lna2 = new ListNode(4);
//        ListNode lna3 = new ListNode(5);
//        ListNode lnb1 = new ListNode(7);
//        ListNode lnb2 = new ListNode(8);
//        ListNode lnb3 = new ListNode(9);
//        lna1.next = lna2;
//        lna2.next = lna3;
//        lnb1.next = lnb2;
//        lnb2.next = lnb3;
//        ListNode newListNode = s.mergeTwoLists(lna1,lnb1);
//        do{
//            System.out.println(newListNode.val);
//            newListNode = newListNode.next;
//        }while(newListNode != null);
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
}