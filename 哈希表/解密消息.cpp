class Solution {
public:
    string decodeMessage(string key, string message) {
        unordered_map<char,char> table;
        int index = 0;
        for (int i = 0 ; i < key.size() ; i++){
            if (key[i] == ' '){
                continue;
            }
            if (table.find(key[i]) != table.end()){
                continue;
            }
            table[key[i]] = 'a' + index;
            index++;
        }

        for (int i = 0 ; i < message.size() ; i++){
            if (table.find(message[i]) != table.end()){
                message[i] = table[message[i]];
            }
        }
        return message;
    }
};