graph = input().split(" ")
N = int(graph[0])
M = int(graph[1])
tree = {}
adjacencyList = [0] * (N + 1)
count_forests = 0
for i in range(N + 1):
    if i != 0:
        tree[str(i)] = 0
for i in range(M):
    edge = input().split(" ")
    if int(edge[0]) < int(edge[1]):
      adjacencyList[int(edge[1])] = int(edge[0])
    else:
        adjacencyList[int(edge[0])] = int(edge[1])
    tree[edge[0]] += 1
    tree[edge[1]] += 1

for i in reversed(range(2, len(tree))):
    check_child = 1
    if tree[str(i)] % 2 is 0:
        for j in reversed(range(2, len(tree))):
            if (adjacencyList[j] is i) and (tree[str(j)] % 2 is 0):
                check_child = 0
        if check_child:
            count_forests += 1
            tree[str(adjacencyList[i])] -= 1
            adjacencyList[i] = -1
print(count_forests)