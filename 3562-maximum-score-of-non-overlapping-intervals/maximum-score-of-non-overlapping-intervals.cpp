class BIT {
    vector<long long> bit;
    vector<vector<long long>> lexo_small;
    int N;

public:
    BIT(int n) {
        bit.assign(n + 1, 0);
        N = n + 1;
        lexo_small.assign(n + 1,{});
    }

    void update(int ind, long long val, vector<long long> indes) {
        sort(indes.begin(), indes.end());
        for (int i = ind; i < N; i += (i & (-i))) {

            if (bit[i] < val) {
                lexo_small[i] = indes;
            } else if(bit[i] == val)
                lexo_small[i] = min(lexo_small[i], indes);
            bit[i] = max(bit[i], val);
        }
    }

    vector<long long> give_max(int i) {
        long long ans = 0;
        vector<long long> indes;
        for (; i > 0; i -= (i & (-i))) {
            if (ans == bit[i]) {
                indes = min(indes, lexo_small[i]);
            } else if (ans < bit[i]) {
                indes = lexo_small[i];
            }
            ans = max(ans, bit[i]);
        }
        vector<long long> final_res;
        final_res.push_back(ans);
        for (auto it : indes)
            final_res.push_back(it);
        return final_res;
    }
};
class Solution {
public:
    vector<int> maximumWeight(vector<vector<int>>& intervals) {
        set<int> temp;
        for (auto v : intervals) {
            temp.insert(v[0]);
            temp.insert(v[1]);
        }
        unordered_map<int, int> mp;
        int cnt = 1;
        for (auto it : temp) {
            mp[it] = cnt;
            cnt++;
        }
        vector<vector<int>> new_interval;
        for (int i = 0; i < intervals.size(); i++) {
            new_interval.push_back(
                {intervals[i][0], intervals[i][1], intervals[i][2], i});
        }
        sort(new_interval.begin(), new_interval.end());
        BIT bit1(cnt + 1), bit2(cnt + 1), bit3(cnt + 1);
        long long ans = 0;
        vector<long long> indes;
        for (int i = 0; i < intervals.size(); i++) {
            vector<long long> ind1, ind2, ind3, ind4;
            map<long long, vector<long long>> curr;

            auto temp1 = bit1.give_max(mp[new_interval[i][0]] - 1);

            if(curr[temp1[0]].size()>0) curr[temp1[0]]=min(curr[temp1[0]],{temp1.begin() + 1, temp1.end()});
            else curr[temp1[0]]={temp1.begin() + 1, temp1.end()};

            for (int i = 1; i < temp1.size(); i++)
                ind1.push_back(temp1[i]);
            ind1.push_back(new_interval[i][3]);
         
            auto temp2 = bit2.give_max(mp[new_interval[i][0]] - 1);

            if(curr[temp2[0]].size()>0) curr[temp2[0]]=min(curr[temp2[0]],{temp2.begin() + 1, temp2.end()});
            else curr[temp2[0]]={temp2.begin() + 1, temp2.end()};


            for (int i = 1; i < temp2.size(); i++)
                ind2.push_back(temp2[i]);
            ind2.push_back(new_interval[i][3]);

            auto temp3 = bit3.give_max(mp[new_interval[i][0]] - 1);

            if(curr[temp3[0]].size()>0) curr[temp3[0]]=min(curr[temp3[0]],{temp3.begin() + 1, temp3.end()});
            else curr[temp3[0]]={temp3.begin() + 1, temp3.end()};

            for (int i = 1; i < temp3.size(); i++)
                ind3.push_back(temp3[i]);
            ind3.push_back(new_interval[i][3]);

          
                sort(ind1.begin(),ind1.end());
                sort(ind2.begin(),ind2.end());
                sort(ind3.begin(),ind3.end());
            bit1.update(mp[new_interval[i][1]], new_interval[i][2], {new_interval[i][3]});

            bit2.update(mp[new_interval[i][1]], temp1[0] + new_interval[i][2], ind1);

            bit3.update(mp[new_interval[i][1]], temp2[0] + new_interval[i][2], ind2);
            
            if(curr[temp3[0] + new_interval[i][2]].size()>0)curr[temp3[0] + new_interval[i][2]] =min(curr[temp3[0] + new_interval[i][2]], ind3);
            else curr[temp3[0] + new_interval[i][2]]=ind3;
            auto it = curr.end();
            it--;
         
            if (ans < it->first) {
                indes = it->second;
                ans = it->first;
            }
            else if( ans==it->first){
                indes=min(indes,it->second);
            }
           
        }
        vector<int> result;
        for(int i=0;i<indes.size();i++)result.push_back(indes[i]);
        return result;
    }
};