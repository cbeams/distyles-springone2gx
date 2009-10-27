package com.bank.app;

def bb = new grails.spring.BeanBuilder();

bb.beans {
	xmlns context:"http://www.springframework.org/schema/context"

	context.'property-placeholder' (
		'location' : 'classpath:/com/bank/app/bank.properties'
	)
	
	feePolicy(com.bank.service.FlatFeePolicy, '${flatfee.amount}')
	accountRepository(com.bank.repository.InMemoryAccountRepository)
	transferService(com.bank.service.TransferServiceImpl, accountRepository, feePolicy)
	tellerUI(com.bank.app.TellerUI, transferService)
}

def ctx = bb.createApplicationContext()
def tellerUI = ctx.getBean(TellerUI.class)
tellerUI.start()