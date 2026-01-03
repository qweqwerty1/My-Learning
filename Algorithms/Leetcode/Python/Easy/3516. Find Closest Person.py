class Solution:
    def findClosest(self, x, y, z):
        det1 = abs(z-x)
        det2 = abs(z-y)

        return 0 if det1 == det2 else 1 if det1 < det2 else 2

def main():
    x, y, z = map(int,input("x value, y value, z value : ").strip().split())
    print(Solution().findClosest(x,y,z))

if __name__ == "__main__":
    main()