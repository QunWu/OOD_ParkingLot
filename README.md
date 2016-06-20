<h4>for any problems, please leave comments under this project. For CMU-Algorithsm students, please keep your questions untils Saturday and I will answer them if we have time after BaiYang's speech</h3>
# OOD_ParkingLot
<div>
Multiple Thread verison for Parking Lot. Car is thread class. Shared values are the enterQue and quitQue which are instances of BlockingQueue.
<ul>
<li>
enterQue is the waiting queue to enter the parking lot. 
</li>
<li>quitQue is the waiting queue to quit the parking lot</li>
</ul>
<p>In another word, before enter/quit the parking, cars firstly go into waiting queue. When gate is serving a car, the function getTicket or paymemt will be invoked. So, Car.java, the thread, is producer while Gate.java is consumer</p>
</div>
<h1>Initial version. Not finished yet</h1>
<div>
Todo List:<ul>
<li>Refine BlockingQueue.java</li>
<li>add ParkingSlot.java</li>
<li>sequence diagram</li>
<li>add UI</li>
</ul>
</div>
