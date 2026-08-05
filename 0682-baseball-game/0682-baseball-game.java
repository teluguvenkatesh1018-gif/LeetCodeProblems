class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk=new Stack<>();
        
        for(String OP: operations){
            if(OP.equals("+")){
                int first=stk.pop();
                int second=stk.peek();
                stk.push(first);
                stk.push(first+second);

            }else if(OP.equals("D")){
                stk.push(2*stk.peek());

            }else if(OP.equals("C")){
                stk.pop();
            }else{
                stk.push(Integer.parseInt(OP));
            }
        }
        int sum=0;

        while(!stk.isEmpty()){
            sum+=stk.pop();
        }
        return sum;
    }
}