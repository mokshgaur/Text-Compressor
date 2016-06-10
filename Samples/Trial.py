d = {"abc":10, "def":20, "ghi":30,20:30}
print(max(set(list(map(lambda x:(x,list(map(lambda x:d[x],d)).count(x)),list(map(lambda x:d[x],d))))),key=lambda x:x[1])[0]);
