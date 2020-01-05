package com.shuonai.gm.util.leetCode;

public class MoreListNode {
      public static void main(String[] args){
            String ddd = "075586511588110\u0000\u0000\u0000";
            //\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000\\u0000";
            System.out.println(ddd);
            System.out.println(ddd.trim());
            System.out.println(ddd.trim().replaceAll("\u0000",""));
      }
      //    private static Map<String,Socket> socketMap = new HashMap<String,Socket>();
//    public static void main(String[] args) throws Exception{
//        //服务端在20006端口监听客户端请求的TCP连接
//        ServerSocket server = new ServerSocket(6110);
//        Socket client = null;
//        boolean f = true;
//        while(f){
//            //等待客户端的连接，如果没有获取连接
//            client = server.accept();
////            InputStream in = null;
////            in = client.getInputStream();
////            //接收从客户端发送过来的数据
//////                String str =  buf.readLine();
////            byte[] byteDatas = new byte[in.available()];
////            in.read(byteDatas);
////            String str = parseByte2HexStr(byteDatas);
////                BinaryToHexString(byteDatas);
////            System.out.println("available::"+str);
//            System.out.println("inetAddress::"+client.getInetAddress().toString()+":"+client.getPort());
//            System.out.println("与客户端连接成功！");
//            //为每个客户端连接开启一个线程
//            new Thread(new ServerThread(client)).start();
//        }
//        server.close();
//    }
      public static String convertHexToString(String hex){

            StringBuilder sb = new StringBuilder();
            StringBuilder temp = new StringBuilder();

            //49204c6f7665204a617661 split into two characters 49, 20, 4c...
            for( int i=0; i<hex.length()-1; i+=2 ){

                  //grab the hex in pairs
                  String output = hex.substring(i, (i + 2));
                  //convert hex to decimal
                  int decimal = Integer.parseInt(output, 16);
                  //convert the decimal to character
                  sb.append((char)decimal);

                  temp.append(decimal);
            }

            return sb.toString();
      }
//      public static void main(String[] args){
//            Solution s = new Solution();
//            ListNode lna1 = new ListNode(1);
//            ListNode lna2 = new ListNode(4);
//            ListNode lna3 = new ListNode(5);
//            ListNode lnb1 = new ListNode(7);
//            ListNode lnb2 = new ListNode(8);
//            ListNode lnb3 = new ListNode(9);
//            lna1.next = lna2;
//            lna2.next = lna3;
//            lnb1.next = lnb2;
//            lnb2.next = lnb3;
//            ListNode newListNode = s.mergeTwoLists(lna1,lnb1);
//            do{
//                  System.out.println(newListNode.val);
//                  newListNode = newListNode.next;
//            }while(newListNode != null);
//      }


//      public ListNode mergeKLists(ListNode[] lists) {
//            ListNode listA = new ListNode(0);
//            ListNode cur = listA;
//            for(ListNode list : lists){
//                  if(cur.val > list.val){
//                        cur = list;
//                        continue;
//                  }else{
//
//                  }
//                  list.val
////                  listA = s.mergeTwoLists(listA,list);
//            }
//            return listA;
//      }

//      public ListNode mergeKLists(ListNode[] lists) {
//            ListNode listA = new ListNode(0);
//            Solution s = new Solution();
//            for(ListNode list : lists){
//                  listA = s.mergeTwoLists(listA,list);
//            }
//            return listA;
//      }

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
