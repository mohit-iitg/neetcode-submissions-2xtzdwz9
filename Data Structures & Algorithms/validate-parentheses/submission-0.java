class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(char ch:s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            } else if(ch == ')') {
                if(stk.size() <= 0 || stk.peek() != '(') return false;
                stk.pop();
            } else if(ch == '}') {
                if(stk.size() <= 0 || stk.peek() != '{') return false;
                stk.pop();
            } else if(ch == ']') {
                if(stk.size() <= 0 || stk.peek() != '[') return false;
                stk.pop();
            } else {
                return false;
            }
        }

        return (stk.size() > 0)?false:true;
    }
}
