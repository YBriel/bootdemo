package com.boot.bootdemo.value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: yuzq
 * remove会报空指针
 * create: 2020-12-01 18:58
 **/
public class RemoveDemo {
    public static void main(String[] args) {
//使用普通for循环遍历ArrayList时，是以索引为依据进行遍历的。在遍历过程中remove元素会导致索引的混乱。比如上例中，当remove（1）后，
// 集合size将发生变化，元素将变少，字符串2所对应的索引将由2变为1，后边的字符串3和4依次类推索引变为2和3，执行下一次循环时，i++为2，此时remove的是字符串3，所以导致了上述结果。
        //添加了删除元素后对下标i进行i--操作，保证下标不错乱。
        List<String> sList = new ArrayList<String>();
        sList.add("0");
        for (int i = 0; i < sList.size(); i++) {
            if(i==1){
                sList.remove(i);
                i--;
            }
        }
//使用迭代器对集合进行遍历，并进行集合中元素的删除操作，如：
        Iterator<String> iterator=sList.iterator();
        while(iterator.hasNext()){
            String item=iterator.next();
            if(item.equals("1")){
                iterator.remove();
                //sList.remove(item);注释的用法是错误用法，迭代器中的迭代需使用迭代器进行删除操作，不能在使用集合的remove方法，此种用法会导致java.util.ConcurrentModificationException
            }
        }

        //removeIf
        sList.removeIf(str-> str.equals("1"));
        System.out.println(sList);

    }
}
