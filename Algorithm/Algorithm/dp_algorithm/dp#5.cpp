#include <iostream>

using namespace std;

int main(){
    int n;
    int dp[10000][10];

    cin>>n;

    for(int i=0; i<=9; i++){
        dp[0][i]=1;
    }
    
    for(int i=1; i<=n; i++){
        dp[i][0]=1;
        
        for(int j=1; j<=9; j++){
            dp[i][j]=(dp[i][j-1]+dp[i-1][j])%10007;
        }
    }

    cout<<dp[n][9];

    return 0;
}