package test;

class Solution {

    public static int solution(String[] ings, String[] menu, String[] sell) {
        
        String list[] = new String[ings.length];
        String val[]=new String[ings.length];
        int res[]=new int[ings.length];
        int num=0, answer=0;
        int value[]=new int[ings.length];
        
        for(int i=0;i<ings.length;i++){
            String s[]=ings[i].split(" ");
            list[i]=s[0]; // 문자열만 저장
            val[i]=s[1]; // 값만 저장
        }

        for(int i=0;i< ings.length;i++){
            String s[]=menu[i].split(" ");
            System.out.println(s[1]);

            for(int j=0;j<s[1].length();j++){
                String now[]=s[1].split("");

                for(int k=0;k<now.length;k++){
                    for(int h=0;h<list.length;h++) {
                        if (now[k].equals(list[h])) {
                            num += Integer.parseInt(val[h]);
                        }
                    }
                }

                res[i]=Integer.parseInt(s[2])-num;
            }
        }

        for(int i=0;i<menu.length;i++){
            for(int j=0;j<sell.length-1;j++){
                String s[]=sell[j].split(" ");
                int count=Integer.parseInt(s[1]);
                if(menu[i].equals(sell[j])){
                    answer+=res[i]*count;
                }
            }
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {

        String ings[]={"r 10", "a 23", "t 124", "k 9"};
        String menu[]={"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30",
                "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
        String sell[]={"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

        System.out.println(solution(ings,menu,sell));

    }

}