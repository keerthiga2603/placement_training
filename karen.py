MAX = 200000
arr = [0] * (MAX + 2)
r,k,q=map(int,input().split())
recipes=[list(map(int,input().split())) for _ in range(r)]
queries=[list(map(int,input().split())) for _ in range(q)]

for i in recipes:
    arr[i[0]]+=1
    arr[i[1]+1]-=1    
for j in range(1,MAX+2):
    arr[j]+=arr[j-1]

res=[]
for m in arr:
    if m>=k:
        res.append(1)
    else:
        res.append(0)

for n in range(1,len(arr)):
    res[n]+=res[n-1]

for x in queries:
    print(res[x[1]]-res[x[0]-1])