// class Queue{

//     constructor(){
//         this.collection = [];
//     };

//     enqueue = (element) => {
//         return this.collection.push(element);
//     };

//     dequeue = () => {
//         return this.collection.shift();
//     };

//     front = () => {
//         return this.collection[0];
//     };

//     size = () => {
//         return this.collection.length;
//     };

//     isEmpty = () =>{
//         return (this.collection.length === 0);
//     };

//     print = () => {
//        this.collection;
//     };
// }

// const q = new Queue();
// q.enqueue('a');
// q.enqueue('b');
// q.enqueue('c');
// console.log("The queue elements are: ", q.print());
// console.log("The Front of the queue is :",q.front());
// q.dequeue();
// console.log("The queue element after dequeue are: ",q.print());

class Queue {
  constructor() {
    this.items = {};
    this.rear = 0;
    this.front = 0;
  }

  enqueue(element) {
    this.items[this.rear] = element;
    this.rear++;
  }

  dequeue() {
    const item = this.items[this.front];
    delete this.items[this.front];
    this.front++;
    return item;
  }

  isEmpty() {
    return this.rear - this.front === 0;
  }

  peek() {
    return this.items[this.front];
  }

  size() {
    return this.rear - this.front;
  }

  print() {
    console.log(this.items);
  }
}

const queue = new Queue();
console.log(queue.isEmpty());

queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

console.log(queue.size());
console.log(queue.print());

console.log(queue.dequeue());
console.log(queue.peek());
console.log(queue.print());
