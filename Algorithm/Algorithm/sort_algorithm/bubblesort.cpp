#include <iostream>
using namespace std;

int main() {
	int a[10] = { 0, };
	int n;
	cout << "입력하시오:" << endl;
	cin >> n;

	cout << "배열만드시오" << endl;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	int brk = n;

	for (int i = 1; i <= n - 1; i++) {
		int cou = 0;
		for (int j = 1; j <= brk - 1; j++) {
			if (a[j - 1] > a[j]) {
				int temp = a[j - 1];
				a[j - 1] = a[j];
				a[j] = temp;

				cou = j;              //불필요한 비교를 피하기 위해 해당 패스에서 마지막으로 swap된 인덱스를 저장한다.
			}
		}
		brk = cou;
	}

	for (int i = 0; i < n; i++) {
		cout << a[i] << endl;
	}
	return 0;

	//시간 복잡도 O(n^2)
}