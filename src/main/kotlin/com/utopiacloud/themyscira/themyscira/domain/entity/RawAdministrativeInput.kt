package com.utopiacloud.themyscira.themyscira.domain.entity

import java.lang.reflect.Field
import java.util.*
import java.util.stream.Collectors
import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "raw_administrative_input")
class RawAdministrativeInput(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,

        /** 法人名称 **/
        var name: String? = null,
        /** 所轄庁 **/
        var competentAuthorities: String? = null,
        /** 主たる事務所の所在地 **/
        var address: String? = null,
        /** 従たる事務所の所在地 **/
        @Lob // 複数住所が改行されて入っているパターンがある
        var addressSub: String? = null,
        /** 代表者氏名 **/
        var representative: String? = null,
        /** 法人設立認証年月日 **/
        var establishedDate: String? = null,
        /** 定款に記載された目的 **/
        @Lob
        var purpose: String? = null,
        /** 活動分野１ **/
        var sector1: String? = null,
        /** 活動分野２ **/
        var sector2: String? = null,
        /** 活動分野３ **/
        var sector3: String? = null,
        /** 活動分野４ **/
        var sector4: String? = null,
        /** 活動分野５ **/
        var sector5: String? = null,
        /** 活動分野６ **/
        var sector6: String? = null,
        /** 活動分野７ **/
        var sector7: String? = null,
        /** 活動分野８ **/
        var sector8: String? = null,
        /** 活動分野９ **/
        var sector9: String? = null,
        /** 活動分野１０ **/
        var sector10: String? = null,
        /** 活動分野１１ **/
        var sector11: String? = null,
        /** 活動分野１２ **/
        var sector12: String? = null,
        /** 活動分野１３ **/
        var sector13: String? = null,
        /** 活動分野１４ **/
        var sector14: String? = null,
        /** 活動分野１５ **/
        var sector15: String? = null,
        /** 活動分野１６ **/
        var sector16: String? = null,
        /** 活動分野１７ **/
        var sector17: String? = null,
        /** 活動分野１８ **/
        var sector18: String? = null,
        /** 活動分野１９ **/
        var sector19: String? = null,
        /** 活動分野２０ **/
        var sector20: String? = null,
        /** 認定（認定・特例認定１） **/
        var approvedSpacial1: String? = null,
        /** 認定（認定・特例認定２） **/
        var approvedSpacial2: String? = null,
        /** 認定（認定・特例認定３） **/
        var approvedSpacial3: String? = null,
        /** 認定（認定・特例認定４） **/
        var approvedSpacial4: String? = null,
        /** 認定（PST基準１） **/
        var approvedPst1: String? = null,
        /** 認定（PST基準２） **/
        var approvedPst2: String? = null,
        /** 認定（PST基準３） **/
        var approvedPst3: String? = null,
        /** 認定（PST基準 条例指定（都道府県及び市区町村名）） **/
        var approvedPstRegulation: String? = null,
        /** 認定（認定開始日） **/
        var approvedStartedDate: String? = null,
        /** 認定（認定満了日） **/
        var approvedEndDate: String? = null,
        /** 認定（認定取消日） **/
        var approvedCancelledDate: String? = null,
        /** 認定（特例認定年月日） **/
        var approvedSpacialStartedDate: String? = null,
        /** 認定（特例認定満了日） **/
        var approvedSpacialEndDate: String? = null,
        /** 認定（特例認定取消日） **/
        var approvedSpacialCancelledDate: String? = null,
        /** 監督情報 **/
        @Lob
        var aboutSupervision: String? = null,
        /** 解散情報 **/
        @Lob
        var aboutDissolution: String? = null,
        /** 法人情報URL **/
        var url: String? = null,
        /** 法人番号 **/
        var corporateNumber: String? = null
) {
    companion object {
        val csvHeader = Arrays.stream(RawAdministrativeInput::class.java.declaredFields)
                .map { t: Field -> t.name }
                .filter { s ->
                    !arrayOf(
                            "id",
                            "csvHeader",
                            "Companion"
                    ).contains(s)
                }
                .collect(Collectors.toList())
                .toTypedArray()
    }
}
