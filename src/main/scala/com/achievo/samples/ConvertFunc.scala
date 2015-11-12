package com.achievo.samples

import javax.swing.JFrame
import javax.swing.JButton
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

/**
 * @author galen.zhang
 */
class ConvertFunc {

}

object ConvertFunc {
  def main(args: Array[String]): Unit = {
    implicit def convertedAction(action: (ActionEvent) => Unit) =
      new ActionListener {
        override def actionPerformed(event: ActionEvent) {
          action(event)
        }
      }

    var data = 0
    val frame = new JFrame("SAM Testing")
    val jButton = new JButton("Counter")
//    jButton.addActionListener(new ActionListener {
//      override def actionPerformed(event: ActionEvent) {
//        data += 1
//        println(data)
//      }
//    })

    jButton.addActionListener((event: ActionEvent) => { data += 1; println(data) })

    frame.setContentPane(jButton)
    frame.pack()
    frame.setVisible(true)
  }

}