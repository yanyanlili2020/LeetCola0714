 class Solution12 {
 public:
     int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
         sort(arr2.begin(), arr2.end());
         int cnt = 0;
         for (auto &x: arr1) {
             unsigned p = lower_bound(arr2.begin(), arr2.end(), x) - arr2.begin();
             bool ok = true;
             if (p < arr2.size()) ok &= (arr2[p] - x > d);
             if (p - 1 >= 0 && p - 1 <= arr2.size()) ok &= (x - arr2[p - 1] > d);
             cnt += ok;
         }
         return cnt;
     }
 };

class Solution12 {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        int b=0;int c=0;int e=0;int f=0;int out=0;
        b=size(arr1);
        c=size(arr2);
        for(int i=0;i<b;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(abs(arr1[i]-arr2[j])>d)
                {e++;}
                else {e=0;break;}

            }
            if(e==c)
                {
                    out=out+1;
                    e=0;
                }
        }
        return out;
    }
};


 class Solution72 {
 public:
     int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
         int cnt = 0;
         for (auto &x: arr1) {
             bool ok = true;
             for (auto &y: arr2) {
                 ok &= (abs(x - y) > d);
             }
             cnt += ok;
         }
         return cnt;
     }
 };