from collections import deque

def bfs(board):
    visited = dict(zip(list(range(0, 101)), [False] * 101))
    neighbors = deque()
    visited[1] = True
    first_value = [1, 0]
    neighbors.append(first_value)
    value = []
    while len(neighbors) != 0:
        value = neighbors.popleft();
        current_position = value[0]
        if current_position == 100:
            break
        for i in range((value[0] + 1), (value[0] + 7)):
            if i < 101:
                if not visited[i]:
                    if i % 10 != 0:
                        x = int(i / 10)
                        y = (i % 10) - 1
                    else:
                        y = 9
                        x = int(i / 10) - 1
                    value_at_position = [board[x][y], value[1] + 1]
                    visited[i] = True
                    neighbors.append(value_at_position)
                    if value_at_position[0] == 100:
                        return value_at_position[1]
            else:
                break
    if not visited[100]:
        return -1
    return value[1]


def main():
    T = int(input())
    for cases in range(T):
        board = []

        # Creating the board for the game
        count = 0
        for i in range(10):
            templist = []
            for j in range(10):
                count += 1
                templist.insert(count, count)
            board.append(templist)

        ladders = int(input())

        # Adding ladders to the board
        for i in range(ladders):
            num = input().split(" ")
            position = int(num[0])
            x = int(position / 10)
            y = (position % 10) - 1
            board[x][y] = int(num[1])

        snakes = int(input())

        # Adding Snakes to the board
        for i in range(snakes):
            num = input().split(" ")
            position = int(num[0])
            x = int(position / 10)
            y = (position % 10) - 1
            board[x][y] = int(num[1])

        print(bfs(board))

if __name__ == '__main__':
    main()