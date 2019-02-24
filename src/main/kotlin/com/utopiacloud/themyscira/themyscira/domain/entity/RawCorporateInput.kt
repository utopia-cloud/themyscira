package com.utopiacloud.themyscira.themyscira.domain.entity

import java.lang.reflect.Field
import java.util.*
import java.util.stream.Collectors
import javax.persistence.*


/**
 *
 */
@Entity
@Table(name = "raw_corporate_input")
class RawCorporateInput(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,

        /** 法人名称 **/
        var name: String? = null,
        /** 組織情報（公開用電話番号） **/
        var tel: String? = null,
        /** 組織情報（ファックス） **/
        var fax: String? = null,
        /** 組織情報（ホームページ） **/
        var homepage: String? = null,
        /** 組織情報（メールアドレス） **/
        var email: String? = null,
        /** 組織情報（常勤職員数） **/
        var fullTimeMembers: String? = null,
        /** 組織情報（事業活動の内容） **/
        var activitySummary: String? = null,


        /** 事業年度（直近の決算） **/
        var currentBusinessYear: Int? = null,
        /** 活動計画書 経常収益計-特定非営利活動に係る事業 **/
        var ordinaryIncomeMain: Long? = null,
        /** 活動計画書 経常収益計-その他の事業 **/
        var ordinaryIncomeOthers: Long? = null,
        /** 活動計画書 経常収益計-合計 **/
        var ordinaryIncomeTotal: Long? = null,
        /** 活動計画書 経常収益計（受取会費）-特定非営利活動に係る事業 **/
        var ordinaryIncomeMembershipFeeMain: Long? = null,
        /** 活動計画書 経常収益計（受取会費）-その他の事業 **/
        var ordinaryIncomeMembershipFeeOthers: Long? = null,
        /** 活動計画書 経常収益計（受取会費）-合計 **/
        var ordinaryIncomeMembershipFeeTotal: Long? = null,
        /** 活動計画書 経常収益計（受取寄附金）-特定非営利活動に係る事業 **/
        var ordinaryIncomeCotributionMain: Long? = null,
        /** 活動計画書 経常収益計（受取寄附金）-その他の事業 **/
        var ordinaryIncomeCotributionOthers: Long? = null,
        /** 活動計画書 経常収益計（受取寄附金）-合計 **/
        var ordinaryIncomeCotributionTotal: Long? = null,
        /** 活動計画書 経常収益計（受取助成金等）-特定非営利活動に係る事業 **/
        var ordinaryIncomeSubsidyMain: Long? = null,
        /** 活動計画書 経常収益計（受取助成金等）-その他の事業 **/
        var ordinaryIncomeSubsidyOthers: Long? = null,
        /** 活動計画書 経常収益計（受取助成金等）-合計 **/
        var ordinaryIncomeSubsidyTotal: Long? = null,
        /** 活動計画書 経常収益計（事業収益）-特定非営利活動に係る事業 **/
        var ordinaryIncomeBusinessMain: Long? = null,
        /** 活動計画書 経常収益計（事業収益）-その他の事業 **/
        var ordinaryIncomeBusinessOthers: Long? = null,
        /** 活動計画書 経常収益計（事業収益）-合計 **/
        var ordinaryIncomeBusinessTotal: Long? = null,
        /** 活動計画書 経常収益計（その他収益）-特定非営利活動に係る事業 **/
        var ordinaryIncomeOthersMain: Long? = null,
        /** 活動計画書 経常収益計（その他収益）-その他の事業 **/
        var ordinaryIncomeOthersOthers: Long? = null,
        /** 活動計画書 経常収益計（その他収益）-合計 **/
        var ordinaryIncomeOthersTotal: Long? = null,

        /** 活動計画書 経常費用計-特定非営利活動に係る事業 **/
        var ordinaryExpenseMain: Long? = null,
        /** 活動計画書 経常費用計-その他の事業 **/
        var ordinaryExpenseOthers: Long? = null,
        /** 活動計画書 経常費用計-合計 **/
        var ordinaryExpenseTotal: Long? = null,
        /** 活動計画書 経常費用計（事業費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseOperationMain: Long? = null,
        /** 活動計画書 経常費用計（事業費）-その他の事業 **/
        var ordinaryExpenseOperationOthers: Long? = null,
        /** 活動計画書 経常費用計（事業費）-合計 **/
        var ordinaryExpenseOperationTotal: Long? = null,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseOperationPersonalMain: Long? = null,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-その他の事業 **/
        var ordinaryExpenseOperationPersonalOthers: Long? = null,
        /** 活動計画書 経常費用計（事業費 (1)人件費）-合計 **/
        var ordinaryExpenseOperationPersonalTotal: Long? = null,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseOperationOthersMain: Long? = null,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-その他の事業 **/
        var ordinaryExpenseOperationOthersOthers: Long? = null,
        /** 活動計画書 経常費用計（事業費 (2)その他経費）-合計 **/
        var ordinaryExpenseOperationOthersTotal: Long? = null,
        /** 活動計画書 経常費用計（管理費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseAdministrativeMain: Long? = null,
        /** 活動計画書 経常費用計（管理費）-その他の事業 **/
        var ordinaryExpenseAdministrativeOthers: Long? = null,
        /** 活動計画書 経常費用計（管理費）-合計 **/
        var ordinaryExpenseAdministrativeTotal: Long? = null,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseAdministrativePersonalMain: Long? = null,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-その他の事業 **/
        var ordinaryExpenseAdministrativePersonalOthers: Long? = null,
        /** 活動計画書 経常費用計（管理費 (1)人件費）-合計 **/
        var ordinaryExpenseAdministrativeTotalOthers: Long? = null,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-特定非営利活動に係る事業 **/
        var ordinaryExpenseAdministrativeOthersMain: Long? = null,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-その他の事業 **/
        var ordinaryExpenseAdministrativeOthersOthers: Long? = null,
        /** 活動計画書 経常費用計（管理費 (2)その他経費）-合計 **/
        var ordinaryExpenseAdministrativeOthersTotal: Long? = null,

        /** 活動計画書 当期経常増減額-特定非営利活動に係る事業 **/
        var ordinalRiseOrFallMain: Long? = null,
        /** 活動計画書 当期経常増減額-その他の事業 **/
        var ordinalRiseOrFallOthers: Long? = null,
        /** 活動計画書 当期経常増減額-合計 **/
        var ordinalRiseOrFallTotal: Long? = null,

        /** 活動計画書 経常外収益計-特定非営利活動に係る事業 **/
        var nonRecurringProfitMain: Long? = null,
        /** 活動計画書 経常外収益計-その他の事業 **/
        var nonRecurringProfitOthers: Long? = null,
        /** 活動計画書 経常外収益計-合計 **/
        var nonRecurringProfitTotal: Long? = null,

        /** 活動計画書 経常外費用計-特定非営利活動に係る事業 **/
        var nonRecurringExpenseMain: Long? = null,
        /** 活動計画書 経常外費用計-その他の事業 **/
        var nonRecurringExpenseOthers: Long? = null,
        /** 活動計画書 経常外費用計-合計 **/
        var nonRecurringExpenseTotal: Long? = null,

        /** 活動計画書 経理区分振替額-特定非営利活動に係る事業 **/
        var accountingClassificationTransferAmountMain: Long? = null,
        /** 活動計画書 経理区分振替額-その他の事業 **/
        var accountingClassificationTransferAmountOthers: Long? = null,
        /** 活動計画書 経理区分振替額-合計 **/
        var accountingClassificationTransferAmountTotal: Long? = null,

        /** 活動計画書 当期正味財産増減額-特定非営利活動に係る事業 **/
        var netAssetRiseOrFallMain: Long? = null,
        /** 活動計画書 当期正味財産増減額-その他の事業 **/
        var netAssetRiseOrFallOthers: Long? = null,
        /** 活動計画書 当期正味財産増減額-合計 **/
        var netAssetRiseOrFallTotal: Long? = null,

        /** 活動計画書 前期繰越正味財産額-特定非営利活動に係る事業 **/
        var previousTermNetAssetMain: Long? = null,
        /** 活動計画書 前期繰越正味財産額-その他の事業 **/
        var previousTermNetAssetOthers: Long? = null,
        /** 活動計画書 前期繰越正味財産額-合計 **/
        var previousTermNetAssetTotal: Long? = null,

        /** 活動計画書 次期繰越正味財産額-特定非営利活動に係る事業 **/
        var nextTermNetAssetMain: Long? = null,
        /** 活動計画書 次期繰越正味財産額-その他の事業 **/
        var nextTermNetAssetOthers: Long? = null,
        /** 活動計画書 次期繰越正味財産額-合計 **/
        var nextTermNetAssetTotal: Long? = null,


        /** 貸借対照表 時点 **/
        var bsTime: Date? = null,
        /** 貸借対照表 資産の部（流動資産） **/
        var bsCurrentAssets: Long? = null,
        /** 貸借対照表 資産の部（固定資産） **/
        var bsFixedAssets: Long? = null,
        /** 貸借対照表 資産の部（資産合計） **/
        var bsTotalAssets: Long? = null,
        /** 貸借対照表 負債の部（流動負債） **/
        var bsCurrentDebt: Long? = null,
        /** 貸借対照表 負債の部（固定負債） **/
        var bsFixedDebt: Long? = null,
        /** 貸借対照表 負債の部（負債合計） **/
        var bsTotalDebt: Long? = null,
        /** 貸借対照表 正味財産の部（前期繰越正味財産） **/
        var bsPreviousTermNetAsset: Long? = null,
        /** 貸借対照表 正味財産の部（当期繰越正味財産） **/
        var bsCurrentTermNetAsset: Long? = null,
        /** 貸借対照表 正味財産の部（正味財産合計） **/
        var bsTotalNetAsset: Long? = null,
        /** 貸借対照表 負債及び正味財産合計 **/
        var bsTotalAmount: Long? = null,

        /** 準拠している会計基準１ **/
        var conformingAccountingStandards1: Int? = null,
        /** 準拠している会計基準２ **/
        var conformingAccountingStandards2: Int? = null,
        /** 準拠している会計基準３ **/
        var conformingAccountingStandards3: Int? = null,

        // TODO これ以下はヘッダーしかないっぽくカンマすらない(MacのNumbersのcountaで確認)
        /** 準拠している会計基準４ **/
        var conformingAccountingStandards4: Int? = null,
        /** 準拠している会計基準５ **/
        var conformingAccountingStandards5: Int? = null,
        /** 準拠している会計基準（その他） **/
        var conformingAccountingStandardsOthers: Int? = null,


        /** 監査の実施１ **/
        var auditConduction1: String? = null,
        /** 監査の実施２ **/
        var auditConduction2: String? = null,
        /** 監査の実施３ **/
        var auditConduction3: String? = null
) {
    companion object {
        val csvHeader = Arrays.stream(RawCorporateInput::class.java.declaredFields)
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

