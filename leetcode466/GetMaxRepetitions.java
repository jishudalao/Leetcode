package leetcode466;

import java.util.HashMap;
import java.util.Map;

public class GetMaxRepetitions {
	public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if(n1==0) return 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = s1.length();
        int l2 = s2.length();
        int couts1=0;//��������s1
        int couts2=0;//��������s2
        int p=0;//��ǰ��s2��λ��
        Map<Integer,int[]> mp = new HashMap<>();//��¼ÿһ��s1ɨ�������ǰ��״̬��Ѱ��ѭ��
        while(couts1<n1){
            for(int i=0;i<l1;i++){
                if(c1[i]==c2[p]){//��ǰ
                    p++;
                    if(p==l2){//s2ɨ�������ͷ��ʼѭ��
                        p=0;
                        couts2++;
                    }
                }
            }
            couts1++;
            if(!mp.containsKey(p)){
                mp.put(p,new int[]{couts1,couts2});//��¼��ǰ״̬
            }
            else{//������ѭ�� ��ν�����p��λ�ú���ǰĳһ��һ��������ѭ��
                int[] last =mp.get(p);
                int circle1= couts1-last[0];
                int circle2= couts2-last[1];
                couts2 += circle2*((n1-couts1)/circle1);
                couts1 = couts1+((n1-couts1)/circle1)*circle1;//����������
            }
        }
        return couts2/n2;
	}
	public static void main(String[] args) {
		String s1 = "abaacdbac";
		String s2 = "adcbd";
		System.out.println(getMaxRepetitions(s1, 100, s2, 4));
	}
}
