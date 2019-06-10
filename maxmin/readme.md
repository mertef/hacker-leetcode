# Description

<object data="./angry-children-English.pdf" type="application/pdf" width="700px" height="700px">
    <embed src="./angry-children-English.pdf">
<p>
You will be given a list of integers, , and a single integer . You must create an array of length  from elements of  such that its unfairness is minimized. Call that array . Unfairness of an array is calculated as
</p>    
    </embed>
</object>

# Code

    func maxMin(k: Int, arr: [Int]) -> Int {
        var maxin = Int.max
        var  sorted = arr.sorted()
    //    let sdesc = sorted.map {
    //        return  "\($0)"
    //    }
        print(sdesc)
        for i in 0..<sorted.endIndex {
            if i + k - 1 < sorted.endIndex {
                let max = sorted[i + k - 1]
                let min = sorted[i]
                let dis = max - min
                //print("dis = \(dis)")
                if maxin > dis {
                    maxin = dis
                }
            }
        }
        return maxin
    
    }
