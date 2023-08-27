#include <iostream>
using namespace std;
int swappingTime = 0;

/*
Problem#1
    Insertion Sort is a classical sorting technique.
    As you probably already know, the algorithm can be really slow.
    To study this more, you want to find out the number of times the
    swap operation is performed when sorting an array.

    Input: 1, 1, 1, 2, 2
    output: 0
    -----------------------
    input 2, 1, 3, 1, 2
    output: 4
*/


void insertionSort(int arr[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            j = j - 1;
            swappingTime++;
        }
        arr[j + 1] = key;
    }
}

int main()
{
    int arr[5];
    for (int i = 0; i<5; i++)
        cin >> arr[i];
    int n = sizeof(arr) / sizeof(arr[0]);
    insertionSort(arr, n);

    cout << swappingTime << endl;

    return 0;
}
