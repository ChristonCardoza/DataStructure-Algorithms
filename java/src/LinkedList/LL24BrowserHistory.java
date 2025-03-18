package LinkedList;

public class LL24BrowserHistory {

    DoubleLLNode<String> currentPage;


    LL24BrowserHistory(String homepage){

        currentPage = new DoubleLLNode<>( homepage);
    }

    void visit(String url){

        DoubleLLNode<String> newNode = new DoubleLLNode<>( url);
        currentPage.next = newNode;
        newNode.prev = currentPage;
        currentPage = newNode;
    }

    String back(int steps) {

        while(steps>0){
            if(currentPage.prev != null){
                currentPage = currentPage.prev;
            } else {
                break;
            }

            steps--;
        }

        return currentPage.data;
    }

    String forward(int steps){
        while(steps>0){
            if(currentPage.next != null){
                currentPage = currentPage.next;
            } else {
                break;
            }
            steps--;
        }
        return currentPage.data;
    }
}
