#include <iostream>
#include <string>
using namespace std;

int minvalue(int a, int b, int c) {
	int min=0;
	if (a >= b && a >= c) {
		if (b <= c)
			min = b;
		else
			min = c;
	}
	else if (b >= a && b >= c) {
		if (c <= a)
			min = c;
		else
			min = a;
	}
	else {
		if (a <= b)
			min = a;
		else
			min = b;
	}

	return min;
}

int main() {
	int E[50][50] = { 0, };
	string s = "", t = "";
	int m, n;       //m= s길이 n=t 길이
	int dis; //s[i] 값과 t[j] 값이 같은지 판별하는 변수, 같으면 0, 다르면 1
	
	cout << "s : " << endl;
	cin >> s;
	cout << "t : " << endl;
	cin >> t;

	m = s.length();
	n = t.length();

	for (int i = 0; i <= m; i++)
		E[i][0] = i;
	for (int j = 0; j <= n; j++)
		E[0][j] = j;

	for (int i = 1; i <= m; i++)
		for (int j = 1; j <= n; j++) {
			if (s[i] == t[j])
				dis = 0;
			else
				dis = 1;
			
			E[i][j]=minvalue(E[i][j - 1] + 1, E[i - 1][j] + 1, E[i - 1][j - 1] + dis);
		}

	cout << "최소 편집 거리 = " << E[m][n] << endl;
}