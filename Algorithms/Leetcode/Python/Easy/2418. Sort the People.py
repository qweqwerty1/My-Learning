class Solution:
    def sortPeople(self, names, heights):
        return [i for _, i in sorted(zip(heights, names), reverse=True)]
        
def main():
    names = ["Mary","John","Emma"] 
    heights = [180,165,170]
    print(Solution().sortPeople(names, heights))
    
if __name__ == "__main__":
    main()