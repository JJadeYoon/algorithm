#include <bits/stdc++.h>   // C++ 표준 라이브러리 거의 전부 포함
using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> v;
    
    for (int num : arr) {
        if (v.empty() || v.back() != num) {
            v.push_back(num);
        }
    }
    
    return v;
}