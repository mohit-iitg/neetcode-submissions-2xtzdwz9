class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<Character>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '('); mp.put('}', '{'); mp.put(']', '[');
        
        for(char ch:s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            } else if(mp.containsKey(ch)) {
                if(stk.size() <= 0 || stk.peek() != mp.get(ch)) return false;
                stk.pop();
            } else {
                return false;
            }
        }

        return (stk.size() > 0)?false:true;
    }
}
