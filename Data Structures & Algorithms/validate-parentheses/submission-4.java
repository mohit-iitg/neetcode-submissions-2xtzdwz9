class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<Character>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '('); mp.put('}', '{'); mp.put(']', '[');
        
        for(char ch:s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            } else if(mp.containsKey(ch)) {
                if(stk.isEmpty() || stk.peek() != mp.get(ch)) return false;
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
}
