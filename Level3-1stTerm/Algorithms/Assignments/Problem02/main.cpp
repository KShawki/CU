#include <iostream>
using namespace std;
long long m_w , m_z;
int n, k;


/*
 * Problem-02
 Given an array A of integers and an integer k,
 you're to get the kth minimum integer in this array.
 Since the array size may be large, the array is not given as input.
 You've to generate it yourself.
 You'll be given the initial values of m_w and m_z, and the array size N.
 Then you've to call this function N times to generate the N array elements.
 */


long long get_random();
void QSort (int arr[], int first, int last);
int partition (int arr[], int first, int last);


int main() {

    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++) {
        arr[i] = get_random();
    }

    QSort(arr, 0, n-1);

    return 0;
}


long long get_random()
 {
     m_z = 36969 * (m_z & 65535) + (m_z >>16);
     m_w = 18000 * (m_z & 65535) + (m_w >>16);
     long long result = (m_z << 16) + m_w;
     return result % 1000000000;
 }

void QSort (int arr[], int first, int last)
{
    if (first < last)
    {
        int part = partition(arr, first, last);
        QSort(arr, first, part-1);
        QSort(arr, part+1, last);
    }
}

int partition (int arr[], int first, int last) {
    int p = arr[last];
    int i = first-1;

    for (int count = first; count <= last-1; count++) {
        if (arr[count] < p) {
            i++;
            int temp = arr[i];
            arr[i] = arr[count];
            arr[count] = temp;
        }
    }

    int temp = arr[i+1];
    arr[1+1] = arr[last];
    arr[last] = temp;

    return i+1;
}