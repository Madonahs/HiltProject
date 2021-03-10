package com.madonasyombua.learninghilt

import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.util.DateUtil
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.util.*

class DataUtilTest {
     val dataUtil = DateUtil()

    @Test
    fun `When date is today then return time of day`() {
        val expected = "5:23 PM"
        val today = Calendar.getInstance().apply { set(2020, 11, 15, 17, 23, 5) }.time
        val dateUtil = DateUtil()
        val output = dateUtil.getFormattedDate(getRecentInvitation(today), today)
        //assertThat(output).isEqualTo(expected)
    }
    @Test
    fun `When date is this week then return day of week`() {
        val expected = "Monday"
        val today = Calendar.getInstance().apply { set(2020, 11, 15, 17, 23, 5) }
        val yesterdayAtAlmostMidnight = (today.clone() as Calendar).apply {
            add(Calendar.DATE, -1)
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
        }
        val dateUtil = DateUtil()
        val output = dateUtil.getFormattedDate(
                getRecentInvitation(yesterdayAtAlmostMidnight.time),
                today.time
        )
        //assertThat(output).isEqualTo(expected)
    }
    @Test
    fun `When date is before this week then return date`() {
        val expected = "12/8/20"
        val today = Calendar.getInstance().apply { set(2020, 11, 15, 17, 23, 5) }
        val oneWeekAgo = (today.clone() as Calendar).apply {
            add(Calendar.DATE, -7)
            set(Calendar.HOUR_OF_DAY, 23)
        }
        val dateUtil = DateUtil()
        val output = dateUtil.getFormattedDate(getRecentInvitation(oneWeekAgo.time), today.time)
      //  assertThat(output).isEqualTo(expected)
    }

   
    private fun getRecentInvitation(date: Date) =
            StudentData(
                    id = 1,
                  school = "",
                    StudentFirstName = "",
                    examScore = "",
                    timestamp = date,
            )
}