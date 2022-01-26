#include <iostream>
#include <algorithm>
using namespace std;

int dp[1000000]={0,};
int main(){
    int input;
    cin>>input;

    for(int i=2; i<=input; i++){
        dp[i]=dp[i-1]+1;
        if(i%2==0){
            dp[i]=min(dp[i],dp[i/2]+1);
        }
        if(i%3==0){
            dp[i]=min(dp[i],dp[i/3]+1);
        }
    }
    cout<<dp[input]<<endl;
    
    return 0;
}