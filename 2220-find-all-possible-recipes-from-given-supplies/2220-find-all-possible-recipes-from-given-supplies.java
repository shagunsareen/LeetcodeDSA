class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //we will create indegree graph for recipes since they can be dependent on each other and not supplies or ingredients
        //put all supplies in hashset to check whether recipe can be made or not by checking supplies in O(1) time
        Set<String> supply = new HashSet<>(Arrays.asList(supplies));

        //indegree is required for topological sort since we will start with recipes which dont have any dependency on other recipe
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();

        //Initialise adjacency list and indegree map
        for(int i=0; i<recipes.length; i++){
            indegree.put(recipes[i], 0); //initially put node with 0 indegree
            //then we check what all ingredients it needs and then we increment its indegree

            for(String ingredient : ingredients.get(i)){
                if(!supply.contains(ingredient)){// that means its a recipe which needs to be completed before current recipe is complete 
                    //adjacency map would have key : ingredient recipe , value : current recipe
                    // bread    -> sandwich, burger
                    // sandwich -> burger
                    adj.computeIfAbsent(ingredient, k-> new ArrayList<>()).add(recipes[i]);
                    indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1); //freq of ingredient recipes to be completed before curr recipe 
                }
            }    
        }

        // Initialize queue with recipes that have 0 indegree
        Queue<String> q = new LinkedList<>();
        for(Map.Entry<String, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0){
                q.offer(entry.getKey());
            }
        }
       
        //Perform topological sort using Kahn's algorithm
        List<String> res = new ArrayList<>();
        while(!q.isEmpty()){
            String currRecipe = q.poll();
            res.add(currRecipe);

            //check if curr recipe's completion decreases someone's dependency
            if(adj.containsKey(currRecipe)){
                for(String nextRecipe : adj.get(currRecipe)){
                    //decrease its indegree 
                    indegree.put(nextRecipe, indegree.get(nextRecipe) - 1);
                    if(indegree.get(nextRecipe) == 0){
                        q.offer(nextRecipe);
                    }
                }
            }
        }

        return res;
    }
}