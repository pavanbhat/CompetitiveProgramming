class Main:
    grid = []
    visited = []
    count = 0

    def __init__(self):
        self.grid = []
        self.visited = []
        self.count = 0

    def check_bounds(self, a, b, m, n):
        if a < 0 or b < 0 or a >= n or b >= m:
            return True
        return False

    def create_visited(self, rows, columns):
        for row in range(rows):
            self.visited += [[False] * columns]

    def solve_wetlands(self, x, y):
        if self.check_bounds(x, y, len(self.grid[0]), len(self.grid)):
            return 0
        if self.grid[x][y] != 'W' or self.visited[x][y]:
            return 0
        self.visited[x][y] = True
        self.count += 1
        self.solve_wetlands(x - 1, y - 1)
        self.solve_wetlands(x, y - 1)
        self.solve_wetlands(x + 1, y - 1)
        self.solve_wetlands(x - 1, y)
        self.solve_wetlands(x + 1, y)
        self.solve_wetlands(x - 1, y + 1)
        self.solve_wetlands(x, y + 1)
        self.solve_wetlands(x + 1, y + 1)
        return self.count


def main():
    T = int(input())
    input()
    for i in range(T):
        sol = Main()
        coordinates = []
        x = 0
        y = 0
        while True:
            row = list(input())
            if row[0].isdigit():
                coordinates = row
                break
            sol.grid.append(row)
        sol.create_visited(len(sol.grid), len(sol.grid[0]))
        if len(coordinates) == 3:
            x = int(coordinates[0])
            y = int(coordinates[2])
            print(sol.solve_wetlands(x - 1, y - 1))
            while True:
                row = input().split()
                sol.visited = []
                sol.create_visited(len(sol.grid), len(sol.grid[0]))
                sol.count = 0
                if len(row) == 0:
                    break
                x = int(row[0])
                y = int(row[1])
                print(sol.solve_wetlands(x - 1, y - 1))
        print()
    print()

if __name__ == '__main__':
    main()
