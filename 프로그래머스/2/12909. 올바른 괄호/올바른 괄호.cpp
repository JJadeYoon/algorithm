#include <bits/stdc++.h>
using namespace std;

bool solution(string s)
{
    vector<char> v;
    
    for (char c : s) {
        if (c == '(') {
            v.push_back(c);
        } else {
            if (v.empty()) {
                return false;
            }
            v.pop_back();
        }
    }

    return v.empty();
}