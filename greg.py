import time
x,y,z=map(int,input().split())
ques=list(map(int,input().split()))
op=[list(map(int,input().split())) for _ in range(y)]
queries=[list(map(int,input().split())) for _ in range(z)]

start_time=time.time()
# print(arr)
# print(op)
# print(queries)

arr=[0 for _ in range(len(op)+1)]
print(arr)
for i in queries:
    arr[i[0]-1]+=1
    arr[i[1]]-=1
for j in range(1,len(op)):
    arr[j]+=arr[j-1]
print(arr)
res=[0 for _ in range(x+1)]
for k in range(len(op)):
    res[op[k][0]-1]+=op[k][2]*arr[k]
    res[op[k][1]]-=op[k][2]*arr[k]
for j in range(1,x+1):
    res[j]+=res[j-1] 
print(res)
result=list(map(lambda x,y:x+y,ques,res))
print(result)




print("Time taken: %s seconds" % (time.time() - start_time))