#include <iostream>
#include <algorithm>
using namespace std;

/*
    Problem 11:
        Given an array of integers, find the subset of non-adjacent elements with the maximum sum.
        Calculate the sum of that subset. It is possible that the maximum sum is 0 ,
        the case when all elements are negative.

        Time complexity O(n)

 */

int MaxSumSubArray (int arr[], int n);

int main() {

    int arr[5], negative = 0;
    for (int i = 0; i<5; i++)
        cin >> arr[i];
    int n = sizeof(arr) / sizeof(arr[0]);


    for (int i=0; i<5 ; i++){
        if (arr[i]<0) negative++;
    }


    if (negative == n) {
        cout << 0 << endl;
    } else {
        cout << MaxSumSubArray(arr, n) << endl;
    }

    return 0;
}

int MaxSumSubArray (int arr[], int n) {
    int exclude = 0;
    int include = arr[0];
    for (int i = 1; i < n; i++) {
        int flag = include;
        include = max(exclude + arr[i], include);
        exclude = flag;
    }
    return include;
}
