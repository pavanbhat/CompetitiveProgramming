
def checkCoords(xcor, ycor, M, N):
    if xcor < 0 or ycor < 0 or xcor >= M or ycor >= N:
        return True
    return False

def checkBounds(startx, starty, endx, endy, M, N):
    if startx < 0 or starty < 0 or endx >= M or endy >= N:
        return True
    return False

def main():
    # Number of test cases
    T = int(input())
    for i in range(T):
        # input values
        val = input().split(' ')
        M = int(val[0])
        N = int(val[1])
        Q = int(val[2])
        row = []
        mat = []
        coordinates = []
        xcor = 0
        ycor = 0
        for j in range(M):
            row = list(input())
            mat.append(row)
        print(M, N, Q)
        for k in range(Q):
            coordinates = input().split(' ')
            xcor = int(coordinates[0])
            ycor = int(coordinates[1])
            if checkCoords(xcor, ycor, M, N):
                print(0)
                continue
            flag = True
            center_val = mat[xcor][ycor]
            for u in range(1, 100):
                startx = xcor - u
                starty = ycor - u
                endx = xcor + u
                endy = ycor + u
                if not checkBounds(startx, starty, endx, endy, M, N):
                    for w in range(startx, endx + 1):
                        if mat[w][starty] != center_val or mat[w][endy] != center_val:
                            flag = False
                            break
                    if flag:
                        for v in range(starty + 1, endy):
                            if mat[startx][v] != center_val or mat[endx][v] != center_val:
                                flag = False
                                break
                else:
                    break
                if not flag:
                    break
            print(2 * u - 1)
    print()


if __name__ == '__main__':
    main()


