              Amazon is experimenting with a flexible storage system for their warehouses. 
              The storage unit consists of a shelving system which is one meter deep with removable vertical 
              and horizontal separators. When all separators are installed, each storage space is one cubic meter (1' x 1' x 1'). 
              Determine the volume of the largest space when a series horizontal and vertical separators are removed.

              leetcode。1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts 

              Time complexity: O(N⋅log(N)+M⋅log(M))
              space is o(1)



       // Start by sorting the inputs
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        
        // Consider the edges first
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for (int i = 1; i < n; i++) {
            // horizontalCuts[i] - horizontalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible height
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        // Consider the edges first
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++){
            // verticalCuts[i] - verticalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible width
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        // Be careful of overflow, and don't forget the modulo!
        return (int) ((maxWidth * maxHeight) % (1000000007));
