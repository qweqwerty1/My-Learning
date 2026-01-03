class Solution:
    def minTimeToVisitAllPoints(self, points):
        dx = points[0][0]
        dy = points[0][1]
        result = 0
        for x, y in points[1:]:
            result += max(abs(dx - x), abs(dy - y))
            dx = x
            dy = y
        return result

def main():
    points = [[1,1],[3,4],[-1,0]]
    sol = Solution()
    print(sol.minTimeToVisitAllPoints(points))

if __name__ == "__main__":
    main()