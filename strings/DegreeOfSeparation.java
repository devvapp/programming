//package


public class DegreeOfSeparation{


    public class Person{

        private int personId;
        private List<Person> friends;

        public Person(int personId){
            this.personId=personId;
        }
    }

    //This is for maintaining track of previously visited nodes
    public class PathNode{

        private Person person;
        private PathNode prev;


        public class PathNode(Person person, PathNode pathNode){
            this.person = person;
            this.pathNode = pathNode;
        }

        public Person getPerson(){
            return person;
        }
    }


    public List<Person> findDegreeOfSeperation(Person source , Person dest){

        Queue<PathNode> toVisitFromSource = new LinkedList<>();
        toVisitFromSource.add(source);
        HashMap<Integer, PathNode> visitedFromSource = new HashMap<Integer, PathNode>();

        Queue<PathNode> toVisitFromDest = new LinkedList<>();
        toVisitFromDest.add(dest);
        HashMap<Integer, PathNode> visitedFromDest = new HashMap<Integer, PathNode>();

        while(toVisitFromSource.isNotEmpty() && toVisitFromDest.isNotEmpty()){
            
            Person collision = searchLevel(source, dest, toVisitFromSource, toVisitFromDest, visitedFromSource, visitedFromDest);

            if(collision != null){
                
            }

            collision = searchLevel(dest, source, toVisitFromSource, toVisitFromDest, visitedFromSource, visitedFromDest);


        }

    }

    public Person searchLevel(Person source, Person dest, Queue<PathNode> toVisitFromSource, 
                Queue<PathNode> toVisitFromDest, Map<Integer, PathNode> visitedFromSource, 
                    Map<Integer, PathNode> visitedFromDest){
        
        for(int i =0; i<toVisitFromSource.size(); i++){
            PathNode pathNode = primary.toVisit.poll();
            int personld = pathNode.getPerson().getId();
            if(visitedFromDest.contains(toVisitFromSource.get(i))){
                return pathNode.getPerson();
            }

            
        }
    }

    public static void main(String[] args) {
        
    }

    
}