#include <iostream>
using namespace std;
int invocation_Count = 0;

/*
*   Problem-03
    Given an array A of integers,
    you're to calculate the number of inversions in this array.
    Number of inversions is the number of pairs (i,j)
    of array indices with i<j and A[i] > A[j] -

    input Format:
    Every test case consists of two lines. The first line in N, the number of array elements.
    The second line contains the array elements themselves.

    *** urgent note: This problem is solved in more than one way, but based on the message of the professor and TA,
                     I decided to solve it in the easiest way possible.
 * */


void InvocationCount (long long arr[], long long n);

int main() {

    long long n;
    cin >> n;
    long long arr[n];

    for (int i=0; i<n; i++)
        cin >> arr[i];

    InvocationCount(arr, n);

    cout << invocation_Count << endl;

    return 0;
}

void InvocationCount (long long arr[], long long n){
    for (int i=0; i<n-1; i++){
        for (int j = i+1; j<n ; ++j) {
            if (arr[i]>arr[j]) {
                invocation_Count++;
            }
        }
    }
}
