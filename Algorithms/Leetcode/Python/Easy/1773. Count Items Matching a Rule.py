class Solution:
    def countMatches(self, items, ruleKey, ruleValue):
        key_dict = {"type" : 0,
                    "color" : 1,
                    "name" : 2}
        target_items = [item[key_dict[ruleKey]] for item in items]
        return target_items.count(ruleValue)

def main():
    items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]] 
    ruleKey = "color"
    ruleValue = "silver"
    print(Solution().countMatches(items, ruleKey, ruleValue))

if __name__ == "__main__":
    main()